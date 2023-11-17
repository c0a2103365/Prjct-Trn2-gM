package javab.ex02;

public class SubStringTest {
	
	public static void main(String[] args) {
		String a = "This is a pen.";
		//インデックス1から(4-1)=3までの値を抽出する．
		String b = a.substring(1,4);
		System.out.println(b);
		
		//インデックス3から最後までを抽出する．
		String c = a.substring(3);
		System.out.println(c);
	}

}
