package javab.ex04;

public class Kadai1Bean {
	
	/**
	 * Kadai1用のデータ保持クラスです．
	 * 一般に，データ保持用のクラスで，setter/getterを持つクラスをBean
	 * と呼びます．
	 */
	private int id;
	
	private String name;
	
	private double weight;
	
	private double height;

	public Kadai1Bean(int id, String name, double weight, double height) {
		super();
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.height = height;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	
	
	

}
