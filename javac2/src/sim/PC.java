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

public class PC extends Node{   
    public PC(String name ,RoutingTable rt, HashMap<String, ARP> arpMap, 
    HashMap<String, NIC> nicMap, LinkedList<Packet> queue) {
        super(name, rt, arpMap, nicMap, queue);
    }
    @Override
    public void run() {
        Packet packet = new Packet();
        int sleep = packet.getSleep();
        int TL = packet.getTTL();
        int Router_PC2_Loss = 0;
        // 経過時間を格納するリスト（金光作成）
        ArrayList<Long> comTimeList= new ArrayList<Long>();
        // 開始時間を格納するリスト（金光作成）
        ArrayList<String> startTimeList=new ArrayList<String>();
        // 現在時刻を格納するリスト（金光作成）
        ArrayList<String> currentTimeList=new ArrayList<String>();
        // sleep値を格納するリスト（金光作成）
        ArrayList<Integer> sleepList=new ArrayList<Integer>();
        // ------------------------------ 追加箇所12/08
        Packet count_drop = new Packet();
        int countDrop = count_drop.getCount_drop();
        //PCとしての個別の処理を書く.
        //ルータとしての個別の処理を書く
        while(true){
            //System.out.println(TL);
            if(TL <= 0){
            System.out.println("通信終了");
            break;
            }
            try{
                //------------------------追加箇所12/08
                countDrop = count_drop.getCount_drop();
                // System.out.println("ロスした累積" + countDrop);//確認用
                if(countDrop>0){
                    sleep = packet.upSleep();
                    System.out.println("sleepを伸ばします");
                }
                
                sleepList.add(sleep);
                System.out.println("sleep: "+ sleep + "ms");//確認用
                Thread.sleep(sleep);
                //System.out.println("私はPC"+this.getName());
                //送信先のルータ番号をランダムに生成
                //int idx = (int)(10*Math.random());
                if(this.getName().equals("pc0")){
                    HashMap<String, RouteRecord> rt = this.getRt().getRouteList();
                    //デフォルトルートを取得
                    RouteRecord defaultRoute = rt.get("0.0.0.0");
                    //NextHopのIPを取得
                    String nextHop = defaultRoute.getNextHop();
                    //NextHopから，NICを取得
                    NIC nextNic = DB.getIns().getNicMap().get(nextHop);
                    //履歴情報を生成
                    History h = new History("192.168.1.10", "192.168.1.11",System.currentTimeMillis());
                    //パケットを生成
                    Packet p = new Packet("192.168.1.10", "192.168.1.11", "mac1", 
                    "mac1",new LinkedList<History>(), "PC0はPC1にパケットを送信" );
                    System.out.println("------------------"+TL+"--------------------");
                    p.getHistoryList().add(h);
                    //NICにパケットを渡す
                    nextNic.putPacket(p);
                    //----------------------追加箇所12/08
                    if(countDrop > 0){
                        System.out.println("---------------"+"パケロス分"+"--------------");//仕分け（区切り)
                        count_drop.countDownDrop();
                    }else{
                        System.out.println("---------------"+ TL +"--------------");
                        TL -= 1;
                    }
                    sleep = packet.downSleep();
                }
                if(this.getName().equals("pc1")){
                    try{
                        if(this.packetQueue.isEmpty()){
                            //System.err.println("PC2_キューが０");
                            //もしキューが空っぽなら，次のループ
                        }else{
                            System.out.println("PC2パケットサイズ" + this.packetQueue.size());
                            if(this.packetQueue.size() > DB.getIns().getMaxQueueSize()){
                            this.getPacketQueue().removeLast();
                            System.out.println("きえたで");
                            Router_PC2_Loss++;
                            // ------------------------------ 追加箇所12/15
                            packet.countUpDrop();

                            continue;
                            }
                            Packet p = this.pollPacket();
                            Thread.sleep(sleep);       
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
                            // 送信時間をリストに格納（金光作成）
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
                            History h2 = new History(name, name, startTime);
                            p.getHistoryList().add(h2);
                            //PC1 -> Router1の時間
                            System.out.println("Router->PC2 : " + comTime);
                        } 
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                } 
            }catch(Exception e){
                e.printStackTrace();
            }
            TL -= 1;


            try {
            // 出力ファイルの作成
            FileWriter fw = new FileWriter("pc.csv", false);
            // PrintWriterクラスのオブジェクトを生成
            PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
            // ヘッダーの指定
            pw.print("StartTime");
            pw.print(",");
            pw.print("CurrentTime");
            pw.print(",");
            pw.print("ElapsedTime");
            pw.print(",");
            pw.print("SleepTime");
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
        // // comTimeListの中身を確認（金光作成）
        // System.out.println(comTimeList);
        // // startTimeListの中身を確認（金光作成）
        // System.out.println(startTimeList);
        // // currentTimeListの中身を確認（金光作成）
        // System.out.println(currentTimeList);
        // System.out.println(sleepList);
        System.out.println("---PC2でロスした数 : " + Router_PC2_Loss + " / " + (1000-Router.PC1_Router_Loss));

        // comTimeListとstartTimeListとcurrentTimeListをcsvファイルに出力
        

    }  
}
