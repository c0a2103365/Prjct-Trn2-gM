
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;

public class Node implements Runnable{

    /**
     * 名前
     */
    protected String name;

    /**
     * ルーティングテーブル
     */
    protected RoutingTable rt;

    /**
     * ARPテーブルのマップ
     */
    protected HashMap<String, ARP> arpMap;

    /**
     * Nicのマップ
     */
    protected HashMap<String, NIC> nicMap;

    protected boolean isRouter;

    /**
     * パケット受信用のキュー
     * @param name
     * @param rt
     * @param arpMap
     * @param nicMap
     */
    protected LinkedList<Packet> packetQueue;//キューのりすと　現在無制限　＝　制限を掛ける必要がある　

    public Node(String name, 
    RoutingTable rt, 
    HashMap<String, ARP> arpMap, 
    HashMap<String, NIC> nicMap, 
    LinkedList<Packet> queue) {
        this.name = name;
        this.rt = rt;
        this.arpMap = arpMap;
        this.nicMap = nicMap;
        this.packetQueue = queue;
        this.isRouter = false;
    }

    

    @Override
    public void run() {
        while(true){
            System.err.println("Node_run 開始");
            try{
                Thread.sleep(10);
                 // TODO Auto-generated method stub
                if(this.isQueueEmpty()){
                    System.err.println("キューが０");
                }else{
                    //キューが空でないときは取り出そうとする。
                    if(this.packetQueue.size() > DB.getIns().getMaxQueueSize()){
                        //packerを消す。
                        this.getPacketQueue().removeLast();
                        System.out.println("消えたで");
                        continue;
                    }else{
                        Packet p = this.getPacketQueue().poll();
                        
                    }
                }
                    
            }catch(Exception e){
                e.printStackTrace();
            }
        }
       
            
        
        
    }

    

    public void addPacket(Packet p){
        //キューの後ろに追加
        this.packetQueue.offer(p);
    }

    public Packet pollPacket(){
        return this.packetQueue.poll();
    }

    public boolean isQueueEmpty(){
        return this.packetQueue.isEmpty();
    }

    



    public RoutingTable getRt() {
        return rt;
    }

    public void setRt(RoutingTable rt) {
        this.rt = rt;
    }

    public HashMap<String, ARP> getArpMap() {
        return arpMap;
    }

    public void setArpMap(HashMap<String, ARP> arpMap) {
        this.arpMap = arpMap;
    }

    public HashMap<String, NIC> getNicMap() {
        return nicMap;
    }

    public void setNicMap(HashMap<String, NIC> nicMap) {
        this.nicMap = nicMap;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }





    public LinkedList<Packet> getPacketQueue() {
        return packetQueue;
    }





    public void setPacketQueue(LinkedList<Packet> packetQueue) {
        this.packetQueue = packetQueue;
    }



    public boolean isRouter() {
        return isRouter;
    }



    public void setRouter(boolean isRouter) {
        this.isRouter = isRouter;
    }

    



    







}
