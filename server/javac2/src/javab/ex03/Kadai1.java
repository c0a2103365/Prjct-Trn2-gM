package javab.ex03;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * リストの基本操作
 * ポイント: java.util.ArrayListとjava.util.Iteratorをimportしてください．
 *
 *
 */

public class Kadai1 {
	public static void main(String[] args) {
		/**
		 * ポイント: 自分の情報に変えてください
		 */
		System.out.println("学籍番号:C0A21033:" + "氏名:金光駿弥");
		/**
		 * リスト
		 */
		ArrayList<String> sList = new ArrayList<String>();
		//ループにて，「要素[番号]」という要素を追加する．
		for(int i=0;i<10;i++) {
			sList.add("要素"+i);
		}

		/**
		 * ポイント: sListの要素数を，ArrayListのメソッドを使って出力させてください．
		 *
		 */
		System.out.println("sListの要素数は"+ sList.size());
		/**
		 * ポイント: sListのインデックス5の要素の値を出力させてください．
		 */
		System.out.println("インデックス5の要素:"+sList.get(5) );

		/**
		 * ポイント: sListのインデックス5を，「要素999」という文字列で更新してください．
		 */
		sList.set(5,"要素999");

		/**
		 * ポイント: 要素999を挿入した後のsListにおいて，インデックス9の要素を削除してください．
		 */
		sList.remove(9);

		//sListのイテレータを取得
		Iterator<String> sIte = sList.iterator();
		int idx = 0;
		while(sIte.hasNext()) {
			/**
			 * ポイント: sIteの次の値（sIte内のメソッドを使う）をvalへ代入してくだｄさい．
			 */
			String val =sIte.next();
			System.out.println("index"+idx+":"+val);
			idx++;
		}
	}
}
