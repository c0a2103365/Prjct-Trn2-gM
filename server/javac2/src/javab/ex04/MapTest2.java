package javab.ex04;

import java.util.HashMap;
import java.util.Iterator;

public class MapTest2 {

	public static void main(String[] args) {

		/**
		 * <文字列, 数値>としての形式のmap
		 */
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		//要素の追加(3人)
		map.put("田中", 100);
		map.put("佐藤", 70);
		map.put("工科", 30);

		//要素の更新(putで良い）
		map.put("田中", 50);
		//keyをもとにした値の取得(get)
		System.out.println("田中さんの最新の点数は"+map.get("田中"));

		//佐藤さんをkeyによって削除
		map.remove("佐藤");

		//指定のkeyがあるかどうかのチェック
		if(map.containsKey("佐藤")) {
			System.out.println("佐藤さんはちゃんといますよ");
		}else {
			System.out.println("佐藤さんはいません");
		}
		System.out.println();

		System.out.println("keyの列挙");
		//keyのiterator
		Iterator<String> keyIte = map.keySet().iterator();
		while(keyIte.hasNext()) {
			String name = keyIte.next();
			System.out.println("名前:"+name);
		}
		System.out.println();
		System.out.println("valueの列挙");
		//valueのiterator
		Iterator<Integer> vIte = map.values().iterator();
		while(vIte.hasNext()) {
			Integer val = vIte.next();
			//プリミティブ型intに変換してみる（やらなくてもいいけど）
			int v = val.intValue();
			System.out.println(v);
		}


	}

}
