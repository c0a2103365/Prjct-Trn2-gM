package javab.ex05;

public class StaticProxyTest {

	public static void main(String[] args) {
		IPerson p = new StaticIPersonProxy(new Person());
		
		p.sayHello();
	}

}
