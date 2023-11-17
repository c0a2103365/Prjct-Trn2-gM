package javab.ex02;

public class ZenkakuTEst {

	public static void main(String[] args) {
		String a = "工科太郎";
		System.out.println("Length:"+a.length());
		
		//インデックス1~2までを抜き出す．
		String b = a.substring(1, 3);
		System.out.println("b:"+b);
		

	}

}
