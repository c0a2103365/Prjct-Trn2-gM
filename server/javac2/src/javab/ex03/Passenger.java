package javab.ex03;

/**
 * Personクラス
 * @author kanemih
 *
 */
public class Passenger {

    /**
     * 乗客ID
     */
    protected int pID;
    
    /**
     * 名前
     */
    protected  String name;
    
    protected Luggage myLuggage;

    /**
     * コンストラクタ
     * @param pID
     * @param name
     */
	public Passenger(int pID, String name, Luggage bag) {
		this.pID = pID;
		this.name = name;
		this.myLuggage = bag;
	}

	public Luggage getMyLuggage() {
		return myLuggage;
	}

	public void setMyLuggage(Luggage myLuggage) {
		this.myLuggage = myLuggage;
	}

	public int getpID() {
		return pID;
	}

	public void setpID(int pID) {
		this.pID = pID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
