package javab.ex05;

import java.lang.reflect.Proxy;

public class Kadai2 {

	public static void main(String[] args) {

		/**
		 * ポイント: 自分の情報に変えてください
		 */
		System.out.println("学籍番号:C0A21033:" + "氏名:金光駿弥");

		/**
		 * ポイント: 45歳で，名前が「工科太郎」としてインスタンス化してください．
		 */
		OldIdle idle = new OldIdle(45, "工科太郎");

		System.out.println("心の中: 実は私の年齢は"+idle.getMyAge()+"です");

		/**
		 * ポイント: UsoHandlerに，idleをセットさせた状態でインスタンス化してください．
		 */
		UsoHandler handler = new UsoHandler(idle);

		/**
		 * ポイント
		 * 第一引数は，idleからのクラスローダ，第ニ引数は，IAgeのもの，第三引数
		 * はhandlerを指定してください．
		 */
		IAge usoTuki = (IAge)Proxy.newProxyInstance(
				idle.getClass().getClassLoader(),
				new Class[] {IAge.class},
				handler);

		System.out.println("皆の前:私のね，年齢は"+usoTuki.getMyAge()+"歳です");
	}
}
