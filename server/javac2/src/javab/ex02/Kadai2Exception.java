package javab.ex02;

public class Kadai2Exception extends Exception {
	private String reason;

	public Kadai2Exception(String msg, String point) {
		/**
		 * ポイント: msgとpointの結合した文字列をスーパークラスの
		 * コンストラクタへ渡すようにしてください．
		 * StringBufferを使って結合しても良いです．
		 */
		//StringBufferでも可
		super(msg+point);
		
	}

	public void printMsg() {
		System.out.println("ダメでしたね");
	}

}
