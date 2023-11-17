package javab.ex02;

public class StrinbBufferTest {

	public static void main(String[] args) {
		String a = "Hello World";
		StringBuffer b = new StringBuffer("Hellow World");
		String c = a;
		long start_a = System.currentTimeMillis();
		//aの追加
		for(int i=0;i<5000;i++) {
			c = c + "Test"+i;
		}
		long end_a = System.currentTimeMillis();
		
		System.out.println("+による時間:"+(end_a - start_a) + "ms");
		
		long start_b = System.currentTimeMillis();
		//bのStringBufferによる追加
		for(int j=0;j<5000;j++) {
			b.append("Test"+j);
		}
		long end_b = System.currentTimeMillis();
		System.out.println("StringBufferによる時間"+(end_b-start_b) + "ms");
		//bを文字列にする場合は，b.toString();
		
		String z = "こんにちは";

	}

}
