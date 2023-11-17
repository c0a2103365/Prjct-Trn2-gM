package sim;

import java.util.*;

public class RoutingTable {


    public RoutingTable(){
        this.routeList = new HashMap<String, RouteRecord>();
    }
    /**
     * <NWアドレス，レコード情報>のMap
     */
    private HashMap<String, RouteRecord> routeList;

    
    public HashMap<String, RouteRecord> getRouteList() {
        return routeList;
    }
public RoutingTable(HashMap<String, RouteRecord> routeList) {
        this.routeList = routeList;
    }


    public void setRouteList(HashMap<String, RouteRecord> routeList) {
        this.routeList = routeList;
    }
    
}
