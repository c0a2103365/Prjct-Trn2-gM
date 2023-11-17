package javab.ex02;

import java.util.StringTokenizer;

public class Kadai2Tokenizer {

	/**
	 * 入力情報
	 */
	private String line;

	/**
	 * 区切り文字
	 */
	private String delimiter;

	/**
	 * コンストラクタ
	 * @param msg 分割対象の文字列
	 * @param del 区切り文字
	 */
	public Kadai2Tokenizer(String msg, String del) {
		this.line = msg;
		this.delimiter = del;
	}


	/**
	 * 指定のインデックス値にある要素を返します．
	 * @param idx
	 * @return
	 * @throws Kadai2Exception
	 */
	/**
	 * ポイント: メソッドのthrowsの後に，Kadai2Exceptionを投げるように定義してください．
	 */
	public String getElement(int idx) throws Kadai2Exception {

		//指定の区切り文字delimiterによってlineを分割する
        StringTokenizer st = new StringTokenizer(this.line, this.delimiter);
        int count = 0;
        String retVal = null;
        /**
         * ポイント: idx値が4以上であればKadai2Exceptionを投げるようにしてください．
         * また，引数はそれぞれ"エラー:"と"インデックス大きすぎ"にしてください．
         */
        if(idx>=4) {
        	throw new Kadai2Exception("エラー:","インデックス大きすぎ");
        }
        //分割されたものに対して順に要素を取得するためのループ
        while (st.hasMoreTokens()) {
            /**
             * ポイント: nextToken()を使って，要素をelementへ格納させてください．
             */
            String element = st.nextToken();
            /**
             * ポイント: idx == count時に，retValに，取得した要素を格納して，
             * そしてループを抜けるようにしてください．
             */
            if(idx == count) {
            	retVal=element;
				break;
            	
            }
            count++;

        }

        return retVal;
	}


	private String nextToken(StringTokenizer st) {
		return null;
	}


}
