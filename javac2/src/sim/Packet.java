
import java.util.LinkedList;

public class Packet {
    
    /**
     * 送信元IP
     */
    private String srcIP;
    /*
     * 送信先IP
     */
    private String destIP;

    /**
     * 送信元のMacアドレス
     */
    private String srcMAC;

    /**
     * 送信先のMacアドレス
     */
    private String destMAC;

    /**
     * TTL (Time To Live) ここで指定　ルータを通るごとに-1される処理を書く
     */

    private int TTL = 1000;

    //private int Sleep = 1;

    //-----追加箇所--------

    public static int Sleep = 70;
    public static int count_drop = 0;


    /*
     * 履歴リスト
     */
    private LinkedList<History> historyList;
    

    private String data;

    

    public Packet(){
        this.historyList = new LinkedList<History>();

    }
    

    public Packet(String srcIP, String destIP, String srcMAC, String destMAC, LinkedList<History> historyList,
            String data) {
        this.srcIP = srcIP;
        this.destIP = destIP;
        this.srcMAC = srcMAC;
        this.destMAC = destMAC;
        this.historyList = historyList;
        this.data = data;
    }
    


    
    public String getSrcIP() {
        return srcIP;
    }


    public void setSrcIP(String srcIP) {
        this.srcIP = srcIP;
    }


    public String getDestIP() {
        return destIP;
    }


    public void setDestIP(String destIP) {
        this.destIP = destIP;
    }


    public String getSrcMAC() {
        return srcMAC;
    }


    public void setSrcMAC(String srcMAC) {
        this.srcMAC = srcMAC;
    }


    public String getDestMAC() {
        return destMAC;
    }


    public void setDestMAC(String destMAC) {
        this.destMAC = destMAC;
    }


    public LinkedList<History> getHistoryList() {
        return historyList;
    }


    public void setHistoryList(LinkedList<History> historyList) {
        this.historyList = historyList;
    }


    public String getData() {

        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    public int getTTL() {
        return TTL;
    }

    public int lowerTTL(){
        return TTL -= 1;
    }


    public void setTTL(int tTL) {
        TTL = tTL;
    }

    public int getSleep(){
        return Sleep;
    }

    //-------------------追加箇所 12/08
    public int upSleep(){
        Sleep = 70;
        System.out.println("伸ばした");
        return Sleep;
    }

    public int downSleep(){
        Sleep -=2;
        return Sleep;
    }

    public void countUpDrop(){
        count_drop = count_drop + 1;
        System.out.println("足された");
        System.out.println(count_drop);
    }

    public void countDownDrop(){
        count_drop = count_drop -1;
    }

    public int getCount_drop(){
        return count_drop;
    }


    

}
