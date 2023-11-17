package sim;

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
     * TTL (Time To Live)
     */
    private int TTL;


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


    public void setTTL(int tTL) {
        TTL = tTL;
    }

    

}
