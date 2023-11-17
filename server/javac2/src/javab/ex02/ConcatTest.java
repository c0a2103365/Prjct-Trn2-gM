package javab.ex02;

public class ConcatTest {

	public static void main(String[] args) {
		String a = "Hello World";
		String b = " is Wonderful";
		//通常の+による結合
		String c = a + b;
		System.out.println("c:"+c);
		//concatメソッドによる結合
		String d = a.concat(b);
		System.out.println("d:"+d);
	}
}
