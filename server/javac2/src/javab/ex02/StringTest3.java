package javab.ex02;

public class StringTest3 {

	public static void main(String[] args) {
		String a = "テスト";
		String b = new String("テスト");
		
		//参照している先（アドレス）の比較
		if(a == b) {
			System.out.println("a==b");
		}else {
			System.out.println("a!=b");
		}
		
		//純粋な値の比較
		if(a.equals(b)) {
			System.out.println("aとbはイコール");
		}else {
			System.out.println("aとbはイコールでない");
		}
	}
}
