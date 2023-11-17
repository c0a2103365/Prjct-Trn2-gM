package javab.ex05;

public class StaticIPersonProxy implements IPerson {
	
	private IPerson targetObj;

	public StaticIPersonProxy(IPerson p) {
		this.targetObj = p;
	}
	@Override
	public void sayHello() {
		System.out.println("@StaticIPersonProxy START");
		this.targetObj.sayHello();
		System.out.println("@StaticIPersonProxy END");

	}

	@Override
	public int getAge() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public void setAge(int age) {
		
	}

	@Override
	public String getName() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO 自動生成されたメソッド・スタブ
		
	}


}
