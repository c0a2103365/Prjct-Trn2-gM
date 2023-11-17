package sim;

/**
 * 経路情報を表すクラスです．
 */
public class RouteRecord {
    
    /**
     * NWアドレス
     */
    private String nwAddress;

    /**
     * 
     */
    private String mask;

    /**
     * 次に転送する先のIPアドレス
     */
    private String nextHop;

    /**
     * NextHopのIPを管理するノードの名前
     */
    private String nextHopName;


    /**
     * 出口のインタフェース名
     */
    private String interfaceName;

    /*
     * ルーティングのメトリック
     */
    private double metric;

    public RouteRecord(String nwAddress, String nextHop, String nextName, String interfaceName) {
        this.nwAddress = nwAddress;
        this.nextHop = nextHop;
        this.interfaceName = interfaceName;
        this.nextHopName = nextName;
    }

    public String getNwAddress() {
        return nwAddress;
    }

    public void setNwAddress(String nwAddress) {
        this.nwAddress = nwAddress;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public String getNextHop() {
        return nextHop;
    }

    public void setNextHop(String nextHop) {
        this.nextHop = nextHop;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public double getMetric() {
        return metric;
    }

    public void setMetric(double metric) {
        this.metric = metric;
    }

    public String getNextHopName() {
        return nextHopName;
    }

    public void setNextHopName(String nextHopName) {
        this.nextHopName = nextHopName;
    }
    

    
    


}
