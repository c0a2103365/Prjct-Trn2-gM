package javab.ex02;

public class Kadai1 {

	public static void main(String[] args) {
		/**
		 * ポイント0: まずは各自の学籍番号＋指名を出力
		 */
		System.out.println("学籍番号:C0A21033:" + "氏名:金光駿弥");
		String msg = "東京工科大学コンピュータサイエンス学部";
		/**
		 * ポイント1: substringメソッドの活用
		 */
		//大学名を抽出
		String university =msg.substring(0,6);
		System.out.println("ポイント1: 大学名:"+university);
		
		/**
		 * ポイント2: substringメソッドの活用
		 */
		//引数は一つのみにしてください．
		String gakubu =msg.substring(6,19);
		System.out.println("ポイント2:学部名:"+gakubu);
		
		/**
		 * ポイント3: 文字列連結
		 * まずはStringBufferのインスタンス時に，
		 * "東京工科大学"を渡す．
		 * そして，その後に，
		 * - ":コンピュータサイエンス学部:"を追加
		 * - "工科太郎"を追加
		 * をStringBufferのメソッドを使ってそれぞれ行ってください．
		 * このメソッドを使うのは2回にしてください．
		 * そして，結合後の文字列を出力してください．
		 */
		StringBuffer buf =new StringBuffer(university);
		buf.append(":"+gakubu+":");
		buf.append("工科太郎");
				
				
		System.out.println("ポイント3:"+buf);

		
				
		
		
		
		

	}

}
