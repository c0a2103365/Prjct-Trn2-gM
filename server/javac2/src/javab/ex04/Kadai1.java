package javab.ex04;

import java.util.*;

/**
 * ポイント: java.util.*;をimportさせてください．
 *
 */
public class Kadai1 {

	public static void main(String[] args) {
		/**
		 * ポイント: 自分の情報に変えてください
		 */
		System.out.println("学籍番号:C0A21033:" + "氏名:金光駿弥");

		int NUM = 10;

		/**
		 * ポイント: 体重(weight)の昇順に格納して表示させるようなSet実装クラスを
		 * 使って（講義で紹介したもののうちの1つ），まずはインスタンス化してください．
		 */
		TreeSet<Kadai1Bean> kSet = new TreeSet<Kadai1Bean>(new WeightComparator());

		//データの作成
		for(int i=0;i<NUM;i++) {
			double weight = 50 + i * 20;
			double height = 200 - i*3;
			Kadai1Bean bean = new Kadai1Bean(i, "工科太郎その"+i, weight, height);
			/**
			 * ポイント: kSetに，beanを追加させてください．(1行で）
			 */
			kSet.add(bean);

		}

		/**
		 * ポイント: kSetから，iteratorをkIteへ代入させてください．
		 */
		Iterator<Kadai1Bean> kIte = kSet.iterator();

		while(kIte.hasNext()) {
			Kadai1Bean bean = kIte.next();
			System.out.println("id:"+bean.getId() + "/name:"+bean.getName() + "/weight:"+bean.getWeight() + "/height:"+bean.getHeight());
		}





	}

}
