package sim;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;

public class Main {
    public static void main(String[] args) {
        // PC/ルータをインスタンス化して，起動する．

        int num_pc = 2;

        int num_router = 1;

        int nic_num = 2;

        // ルータの起動
        for (int i = 0; i < num_router; i++) {
            // ルータを生成
            Router r = new Router("r" + String.valueOf(i),
                    new RoutingTable(),
                    new HashMap<String, ARP>(),
                    new HashMap<String, NIC>(),
                    new LinkedList<Packet>());
            NIC nic1;
            NIC nic2;
            if (i == 0) {
                // NICを作る．
                // ルータの場合は，NICを2つ用意する．
                nic1 = new NIC("192.168.1.1", "mac" + String.valueOf(i) + 1, "eth1", r);
                nic2 = new NIC("192.168.1.6", "mac" + String.valueOf(i) + 2, "eth2", r);
                // ルータにNICを登録した
                r.getNicMap().put(nic1.getName(), nic1);
                r.getNicMap().put(nic2.getName(), nic2);
                DB.getIns().getNicMap().put(nic1.getIpAddress(), nic1);
                DB.getIns().getNicMap().put(nic2.getIpAddress(), nic2);

                RouteRecord rcd = new RouteRecord("0.0.0.0", "192.168.1.7", "r1", "eth2");
                r.getRt().getRouteList().put(rcd.getNwAddress(), rcd);

            }
            if (i == 1) {
                // NICを作る．
                // ルータの場合は，NICを2つ用意する．
                nic1 = new NIC("192.168.1.7", "mac" + String.valueOf(i) + 1, "eth1", r);
                nic2 = new NIC("192.168.1.8", "mac" + String.valueOf(i) + 2, "eth2", r);
                DB.getIns().getNicMap().put(nic1.getIpAddress(), nic1);
                DB.getIns().getNicMap().put(nic2.getIpAddress(), nic2);

                // ルータにNICを登録した
                r.getNicMap().put(nic1.getName(), nic1);
                r.getNicMap().put(nic2.getName(), nic2);
                RouteRecord rcd = new RouteRecord("0.0.0.0", "192.168.1.11", "pc1", "eth2");
                r.getRt().getRouteList().put(rcd.getNwAddress(), rcd);
            }

            // ルータをDBに登録する
            DB.getIns().getRouterMap().put(r.getName(), r);
            // 例えば，id=2のルータを取ってくる場合は，
            // Router r2 = DB.getIns().getRouter(2);

        }

        for (int j = 0; j < num_pc; j++) {
            PC pc = new PC("pc" + String.valueOf(j), new RoutingTable(), new HashMap<String, ARP>(),
                    new HashMap<String, NIC>(), new LinkedList<Packet>());
            NIC nic1 = null;
            NIC nic2 = null;
            if (j == 0) {
                // NICを作る．
                // ルータの場合は，NICを2つ用意する．
                nic1 = new NIC("192.168.1.10", "mac" + String.valueOf(j) + 1, "eth" + 1, pc);
                DB.getIns().getNicMap().put(nic1.getIpAddress(), nic1);
                // ルータにNICを登録した
                pc.getNicMap().put(nic1.getName(), nic1);
                // 次に，ルーティングテーブルの設定
                RouteRecord rcd = new RouteRecord("0.0.0.0", "192.168.1.1", "r0", "eth1");
                // レコードを経路表に追加
                RoutingTable table = pc.getRt();
                table.getRouteList().put(rcd.getNwAddress(), rcd);
            }
            if (j == 1) {
                // NICを作る．
                // ルータの場合は，NICを2つ用意する．
                nic1 = new NIC("192.168.1.11", "mac" + String.valueOf(j) + 1, "eth" + 1, pc);
                DB.getIns().getNicMap().put(nic1.getIpAddress(), nic1);

                // ルータにNICを登録した
                pc.getNicMap().put(nic1.getName(), nic1);
                // RouteRecord rcd = new RouteRecord("0.0.0.0", "192.168.1.8", "r1", "eth1");
                // レコードを経路表に追加
                // RoutingTable table = pc.getRt();
                // table.getRouteList().put(rcd.getNwAddress(), rcd);
            }

            // PCをDBに登録する
            DB.getIns().getPcMap().put(pc.getName(), pc);
            // 例えばidが3のPCを取ってくる場合は
            // PC pc3 = DB.getIns().getPC(3);

        }

        // 起動処理
        for (int i = 0; i < num_router; i++) {
            // ルータを取得
            Router r = DB.getIns().getRouter("r" + i);
            try {
                // スレッドとして起動
                Thread t = new Thread(r);
                t.start();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        for (int j = 0; j < num_pc; j++) {
            // PCを取得
            PC pc = DB.getIns().getPC("pc" + j);
            try {
                // スレッドとして起動
                Thread t = new Thread(pc);
                t.start();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
