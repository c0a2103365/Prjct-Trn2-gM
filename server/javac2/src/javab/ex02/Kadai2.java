package javab.ex02;

public class Kadai2 {

	public static void main(String[] args) {
		/**
		 * ポイント0: まずは各自の学籍番号＋指名を出力
		 */
		System.out.println("学籍番号:C0A21033:" + "氏名:金光駿弥");
		/**
		 * ポイント: 第2引数を指定してください．
		 */
		Kadai2Tokenizer token = new Kadai2Tokenizer(
				"東京都,八王子市,片倉町,東京工科大学","," );
		/**
		 * ポイント: try-catch-finallyを書いてください．
		 *
		 * finallyのところでは，"完了です．"と出力させるようにしてください．
		 */
		 try{
			System.out.println(token.getElement(0));
			System.out.println(token.getElement(1));
			System.out.println(token.getElement(2));
			System.out.println(token.getElement(3));
			System.out.println(token.getElement(4));

		}catch(Kadai2Exception e){
			e.printStackTrace();
		}finally {
			System.out.println("完了です．");
		}

	}

}
