package sim;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;

public class PC extends Node {

    public PC(String name, RoutingTable rt, HashMap<String, ARP> arpMap,
            HashMap<String, NIC> nicMap, LinkedList<Packet> queue) {
        super(name, rt, arpMap, nicMap, queue);
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        // PCとしての個別の処理を書く.
        // ルータとしての個別の処理を書く
        while (true) {
            try {
                Thread.sleep(1000);
                // System.out.println("私はPC" + this.getName());
                // 送信先のルータ番号をランダムに生成
                // int idx = (int)(10*Math.random());
                if (this.getName().equals("pc0")) {
                    HashMap<String, RouteRecord> rt = this.getRt().getRouteList();
                    // デフォルトルートを取得
                    RouteRecord defaultRoute = rt.get("0.0.0.0");
                    // NextHopのIPを取得
                    String nextHop = defaultRoute.getNextHop();
                    // NextHopから，NICを取得
                    NIC nextNic = DB.getIns().getNicMap().get(nextHop);
                    // 履歴情報を生成
                    History h = new History("192.168.1.10", "192.168.1.11", System.currentTimeMillis());
                    // パケットを生成
                    Packet p = new Packet("192.168.1.10", "192.168.1.11", "mac1",
                            "mac1", new LinkedList<History>(), "hellopo");
                    // 履歴に追加
                    p.getHistoryList().add(h);

                    // NICにパケットを渡す
                    nextNic.putPacket(p);

                }

                /*
                 * if (this.getName().equals("pc1")) {
                 * HashMap<String, RouteRecord> rt = this.getRt().getRouteList();
                 * // デフォルトルートを取得
                 * RouteRecord defaultRoute = rt.get("0.0.0.0");
                 * // NextHopのIPを取得
                 * String nextHop = defaultRoute.getNextHop();
                 * // NextHopから，NICを取得
                 * NIC nextNic = DB.getIns().getNicMap().get(nextHop);
                 * // 履歴情報を生成
                 * History h = new History("192.168.1.11", "192.168.1.10",
                 * System.currentTimeMillis());
                 * // パケットを生成
                 * Packet p = new Packet("192.168.1.11", "192.168.1.10", "mac1",
                 * "mac1", new LinkedList<History>(), "hello");
                 * // 履歴に追加
                 * p.getHistoryList().add(h);
                 * 
                 * // NICにパケットを渡す
                 * nextNic.putPacket(p);
                 * 
                 * }
                 */

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}