

public class History {
    
    /**
     * 送信元IP
     */
    private String srcIP;

    /**
     * 送信先IP
     */
    private String destIP;

    /**
     * 送信元で，パケットを送信開始した時刻
     */
    private long startTime;

    /**
     * 送信先で，パケットが到着した時刻
     */
    private long arrivalTime;

    public History(String srcIP, String destIP, long startTime) {
        this.srcIP = srcIP;
        this.destIP = destIP;
        this.startTime = startTime;
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

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(long arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    
    

}
