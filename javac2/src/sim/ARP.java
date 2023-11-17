package sim;

import java.util.HashMap;

public class ARP {
    /**
     * <IP, MAC>の構造をとったマップ
     */
    private HashMap<String, String> recordMap;

    public ARP(HashMap<String, String> recordMap) {
        this.recordMap = recordMap;
    }

    public HashMap<String, String> getRecordMap() {
        return recordMap;
    }

    public void setRecordMap(HashMap<String, String> recordMap) {
        this.recordMap = recordMap;
    }

    

}
