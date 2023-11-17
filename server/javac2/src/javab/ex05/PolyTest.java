package javab.ex05;

public class PolyTest {

	public static void main(String[] args) {
		IPerson p = new Person();
		p.setAge(100);
		p.setName("工科花子");
		p.sayHello();
		System.out.println("name:"+p.getName() + "/age:"+p.getAge());

	}

}
