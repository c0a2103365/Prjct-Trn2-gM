
import java.util.HashMap;

public class DB {

    //PCのDB
    private HashMap<String, PC> pcMap;
    //routerのDB
    private HashMap<String, Router> routerMap;

    //IPアドレス, NIC
    private HashMap<String, NIC> nicMap;

    private static DB own;

    private int maxQueueSize = 100;

    private DB(){
        this.pcMap = new HashMap<String, PC>();
        this.routerMap = new HashMap<String, Router>();
        this.nicMap = new HashMap<String, NIC>();

    }

    /**
     * 自身のインスタンスを返すメソッド
     * @return
     */
    public static DB getIns(){
        if(DB.own == null){
            DB.own = new DB();
        }else{

        }
        return DB.own; 
    }

    public PC getPC(String id){
        return this.pcMap.get(id);
        
    }

    

    


    
    public int getMaxQueueSize() {
        return maxQueueSize;
    }

    public void setMaxQueueSize(int maxQueueSize) {
        this.maxQueueSize = maxQueueSize;
    }

    public HashMap<String, NIC> getNicMap() {
        return nicMap;
    }

    public void setNicMap(HashMap<String, NIC> nicMap) {
        this.nicMap = nicMap;
    }

    public Router getRouter(String id){
        return this.routerMap.get(id);
        
    }

    public Router getRouter(int id){
        String str_id = String.valueOf(id);
        return this.routerMap.get(str_id);

    }

    public HashMap<String, PC> getPcMap() {
        return pcMap;
    }

    public void setPcMap(HashMap<String, PC> pcMap) {
        this.pcMap = pcMap;
    }

    public HashMap<String, Router> getRouterMap() {
        return routerMap;
    }

    public void setRouterMap(HashMap<String, Router> routerMap) {
        this.routerMap = routerMap;
    }

    

    



    
}
