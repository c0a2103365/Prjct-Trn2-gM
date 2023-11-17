package javab.ex04;

import java.util.*;

/**
 * ポイント: java.util.*をimportしてください．
 *
 */
public class Kadai2 {

	public static void main(String[] args) {
		/**
		 * ポイント: 自分の情報に変えてください
		 */
		System.out.println("学籍番号:C0A21033:" + "氏名:金光駿弥");

		int NUM = 10;

		/**
		 * ポイント: keyの昇順に格納して表示させるようなMap実装クラスを
		 * 使って（講義で紹介したもののうちの1つ），まずはインスタンス化してください．
		 */
		TreeMap<Integer, Kadai2Bean> kMap = new TreeMap<Integer, Kadai2Bean>();

		//データの作成
		for(int i=0;i<NUM;i++) {
			double weight = 50 + i * 20;
			double height = 200 - i*3;
			Kadai2Bean bean = new Kadai2Bean(i, "工科太郎その"+i, weight, height);
			/**
			 * ポイント: kMapに，key: i,value: beanの組を追加させてください．(1行で）
			 */
			kMap.put(i,bean);

		}

		System.out.println("******keyの昇順:");
		/**
		 * ポイント: kMapの値のteratorをkIteへ代入させてください．
		 */
		Iterator<Kadai2Bean> kIte = kMap.values().iterator();

		while(kIte.hasNext()) {
			Kadai2Bean bean = kIte.next();
			System.out.println("id:"+bean.getId() + "/name:"+bean.getName() + "/weight:"+bean.getWeight() + "/height:"+bean.getHeight());
		}


		//HashMapの作成
		HashMap<Integer, Kadai2Bean> hMap = new HashMap<Integer, Kadai2Bean>();

		//データの作成
		for(int i=0;i<NUM;i++) {
			double weight = 50 + i * 20;
			double height = 150 + i*3;
			Kadai2Bean bean = new Kadai2Bean(i, "工科太郎その"+i, weight, height);
			/**
			 * ポイント: hMapに，key: i,value: beanの組を追加させてください．(1行で）
			 */
			hMap.put(i,bean);

		}

		/**
		 * ポイント: LinkedListを使って，hMapのvaluesのリストを作成してください．
		 */
		LinkedList<Kadai2Bean> hList = new LinkedList<Kadai2Bean>(hMap.values());

		/**
		 * ポイント: CollectionsとHeightComparatorを使って，hListをheightの降順にソートさせてください（1行で）
		 */
		Collections.sort(hList,new HeightComparator());

		/**
		 * ポイント: hListのIteratorを代入させてください．
		 */
		Iterator<Kadai2Bean> hIte = hList.iterator();
		System.out.println("******heightの降順:");

		while(hIte.hasNext()) {
			/**
			 * ポイント: hIteの次の要素をbeanに代入させるようにしてください．
			 */
			Kadai2Bean bean = hIte.next();
			System.out.println("id:"+bean.getId() + "/name:"+bean.getName() + "/weight:"+bean.getWeight() + "/height:"+bean.getHeight());

		}

	}

}
