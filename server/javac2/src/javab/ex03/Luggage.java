package javab.ex03;

/**
 * 荷物クラス
 *
 */
public class Luggage {


	/**
	 * この荷物の所有者である乗客ID
	 */
	protected int ownerID;

	/**
	 * 重量
	 */
	protected double weight;

	public Luggage(int ownerID, double weight) {
		this.ownerID = ownerID;
		this.weight = weight;
	}

	public int getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}








}
