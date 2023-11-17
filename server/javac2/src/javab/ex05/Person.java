package javab.ex05;

public class Person implements IPerson {

	private int age;

	private String name;

	@Override
	public void sayHello() {
		System.out.println("スパシーバ");

	}

	@Override
	public int getAge() {
		// TODO 自動生成されたメソッド・スタブ
		return this.age;
	}

	@Override
	public void setAge(int age) {
		// TODO 自動生成されたメソッド・スタブ
		this.age = age;

	}

	@Override
	public String getName() {
		// TODO 自動生成されたメソッド・スタブ
		return this.name;
	}

	@Override
	public void setName(String name) {
		// TODO 自動生成されたメソッド・スタブ
		this.name = name;

	}

}
