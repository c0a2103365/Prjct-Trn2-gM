package javab.ex05;

public class OldIdle implements IAge {

	/**
	 * 自分の年令
	 */
	private int age;
	
	/**
	 * 名前
	 */
	private String name;
	
	
	public OldIdle(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	@Override
	public int getMyAge() {
		return this.age;

	}

	@Override
	public void setMyAge(int newAge) {
		this.age = newAge;

	}

}
