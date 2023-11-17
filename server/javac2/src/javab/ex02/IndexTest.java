package javab.ex02;

public class IndexTest {
	
	public static void main(String[] args) {
		String a = "Hello World";
		//"l"が最初に現れるインデックスを返す．
		int index = a.indexOf("l");
		System.out.println("index:"+index);
		//大文字->小文字にしたものをbへ格納する．
		String b = a.toLowerCase();
		System.out.println("a:"+a + "/b:"+b);
		
		String c = a.toUpperCase();
		System.out.println("a:"+a + "/c:"+c);
		
		//lをkに変える．
		String d = a.replace("l", "k");
		System.out.println("d:"+d);
	}

}
