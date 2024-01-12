

import java.util.LinkedList;

import javax.naming.LinkException;

public class NIC {
 
    /**
     * IPアドレス
     */
    private String ipAddress;

    /**
     * Macアドレス
     */
    private String macAddress;

    /**
     * eth0とか
     */
    private String name;

    /**
     * 自分が所属するルータ
     */
    private Node myNode;


    public NIC(String ipAddress, String macAddress, String name, Node r) {
        this.ipAddress = ipAddress;
        this.macAddress = macAddress;
        this.name = name;
        this.myNode = r;

        
    }

    /**
     * 大事なメソッド
     * packetを渡す
     * 
     * @param p
     */
    public void putPacket(Packet p){
        //ルータのキューにpを入れる．
        Node node = this.getMyNode();
        node.addPacket(p);
    }

    
    

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Node getMyNode() {
        return myNode;
    }



    public void setMyNode(Node myNode) {
        this.myNode = myNode;
    }
   


}
