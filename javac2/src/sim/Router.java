import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;


public class Router extends Node{
    public Router(String name, RoutingTable rt, HashMap<String, ARP> arpMap, 
    HashMap<String, NIC> nicMap, LinkedList<Packet> queue) {
        super(name, rt, arpMap, nicMap, queue);
    }
    public static int PC1_Router_Loss = 0;
    public void run(){
        //ルータとしての個別の処理を書く
        Packet packet = new Packet();
        int sleep =packet.getSleep();
        int TL = packet.getTTL();
        // 開始時間を格納するリスト（金光作成）
        LinkedList<String> startTimeList=new LinkedList<String>();
        // 現在時刻を格納するリスト（金光作成）
        LinkedList<String> currentTimeList=new LinkedList<String>();
        // 経過時間を格納するリスト（金光作成）
        LinkedList<Long> comTimeList= new LinkedList<Long>();
        // sleep値を格納するリスト（金光作成）
        LinkedList<Integer> sleepList=new LinkedList<Integer>();
        //---------追加箇所12/08
        int drop = 0;
        while(true){
            //System.err.println(TL);
            if(TL <= 0) {
                break;
            }
            TL -=1;
            try{
                Thread.sleep(sleep);
                sleepList.add(sleep);
                if(this.packetQueue.isEmpty()){
                    //System.err.println("Router_キューが０");
                    
                    //もしキューが空っぽなら，次のループ
                }else{
                    //キューにパケットが入っていれば，取り出す．
                    System.out.println("Routerパケットサイズ" + this.packetQueue.size());
                    if(this.packetQueue.size() > DB.getIns().getMaxQueueSize()){
                        this.getPacketQueue().removeLast();
                        System.out.println("きえたで");
                        // 追加箇所12/08
                        packet.countUpDrop();
                        PC1_Router_Loss++;
                        continue;
                    }
                    Packet p = this.pollPacket();
                    //中身を出力
                    if(p == null){
                        System.err.println("pnai");
                        continue;
                    }
                    //履歴リストを取り出す
                    LinkedList<History> hList = p.getHistoryList();
                    //最後のやつを取り出す
                    History h = hList.getLast();
                    //現在時刻
                    long curretTime = System.currentTimeMillis();
                    //送信開始時刻
                    long startTime = h.getStartTime();
                    //送信時間(ms)
                    long comTime = curretTime - startTime;
                    // 経過時間をリストに格納（金光作成）
                    comTimeList.add(comTime);
                    // 開始時間をリストに格納（金光作成）
                    Timestamp startTimeStamp=new Timestamp(startTime);
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
                    String startTimeToStr=sdf.format(startTimeStamp);
                    startTimeList.add(startTimeToStr);
                    // 現在時刻をリストに格納（金光作成）
                    Timestamp curretTimeStamp=new Timestamp(curretTime);
                    String curretTimeToStr=sdf.format(curretTimeStamp);
                    currentTimeList.add(curretTimeToStr);
                    h.setArrivalTime(curretTime);
                    History h1 = new History(name, name, startTime);
                    p.getHistoryList().add(h1);
                    //PC1 -> Router1の時間
                    System.err.println("PC1->Router:" + comTime);
                    p.getHistoryList().add(h);
                    HashMap<String, RouteRecord> rt = this.getRt().getRouteList();
                    //デフォルトルートを取得
                    RouteRecord defaultRoute = rt.get("0.0.0.0");
                    //NextHopのIPを取得
                    String nextHop = defaultRoute.getNextHop();
                    //NextHopから，NICを取得
                    NIC nextNic = DB.getIns().getNicMap().get(nextHop);
                    nextNic.putPacket(p);
                } 
            }catch(Exception e){
                e.printStackTrace();
            }


            try {
            // 出力ファイルの作成
            FileWriter fw = new FileWriter("Router.csv", false);
            // PrintWriterクラスのオブジェクトを生成
            PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
            // ヘッダーの指定
            pw.print("StartTime");
            pw.print(",");
            pw.print("CurrentTime");
            pw.print(",");
            pw.print("ComTime");
            pw.print(",");
            pw.print("Sleep");
            pw.println();
            // データを書き込む
            for(int i = 0; i < startTimeList.size(); i++){
                pw.print(startTimeList.get(i));
                pw.print(",");
                pw.print(currentTimeList.get(i));
                pw.print(",");
                pw.print(comTimeList.get(i));
                pw.print(",");
                pw.print(sleepList.get(i));
                pw.println();
            }
            // ファイルを閉じる
            pw.close();
            // 出力確認用のメッセージ
            System.out.println("csvファイルを出力しました");
    }catch(Exception e){
        e.printStackTrace();
        }

        }
        // // startTimeListの中身を確認（金光作成）
        // System.out.println(startTimeList);
        // // currentTimeListの中身を確認（金光作成）
        // System.out.println(currentTimeList);
        System.out.println("--------Routerでロスした数 : " + PC1_Router_Loss + " / 1000");

        // startTimeListとcurrentTimeListをファイルに書き込む（金光作成）
        
    }
}

