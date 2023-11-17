package sim;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;

public class Router extends Node{

    public Router(String name, RoutingTable rt, HashMap<String, ARP> arpMap, 
    HashMap<String, NIC> nicMap, LinkedList<Packet> queue) {
        super(name, rt, arpMap, nicMap, queue);
    }

    public void run(){
        //ルータとしての個別の処理を書く
        while(true){
            try{
                Thread.sleep(10);
                if(this.packetQueue.isEmpty()){
                    //もしキューが空っぽなら，次のループ
                }else{
                    //キュにパケットが入っていれば，取り出す．
                    Packet p = this.pollPacket();
                    //中身を出力
                    System.out.println(p.getData());
                    // 履歴リストを取り出す
                    LinkedList<History> hList=p.getHistoryList();
                    // 最後のやつを取り出す
                    History h=hList.getLast();
                    // 現在時刻
                    long curretTime=System.currentTimeMillis();
                    // 送信開始時刻
                    long startTime=h.getStartTime();
                    // 通信時間(ms)
                    long comTime=curretTime-startTime;
                    h.setArrivalTime(curretTime);
                    History h2=new History(";",name,startTime);
                    p.getHistoryList().add(h2);
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }
        }


    }
}
