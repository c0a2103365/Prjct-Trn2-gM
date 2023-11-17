package javab.ex05;

import java.util.Iterator;

/**
 * 課題1: 
 * ブラウザクラスに対して，プラグインを加えることによって
 * 動的にプラグインをロードしてその機能を呼び出す，という
 * プログラムです．
 * 
 * ポイント: java.util.Iteratorをimportさせてください．
 * 
 */
public class Kadai1 {

	public static void main(String[] args) {
		
		/**
		 * ポイント: 自分の情報に変えてください
		 */
		System.out.println("学籍番号:C0A21033:" + "氏名:金光駿弥");
		
		Browser browser = new Browser();
		System.out.println("***初期状態のメニュー***");
		/**
		 * ポイント: ブラウザのメニューを表示
		 * Mapの「value部」を表示させるように，空欄を埋めてください．
		 */
		Iterator<String> mIte = browser.getMenuMap().values().iterator();
		//メニュー項目(value)に対するループ
		while(mIte.hasNext()) {
			String menu = mIte.next();
			//メニュー項目を表示
			System.out.println(menu);
		}
		System.out.println("*****Pluginを追加させます***");
		/**
		 * Pluginを文字列を指定することによって追加する．
		 * ポイント: MyPluginのクラスを，文字列を指定して追加させてください．
		 * ヒント: パッケージ名も含めたクラス名を指定してください．
		 */
		browser.addPlugin("javab.ex05.MyPlugin");
		
		System.out.println("***Plugin追加後のメニュー**");

		//Plugin追加後のメニュー
		/**
		 * ポイント: ブラウザのメニューを表示
		 * Mapの「value部」を表示させるように，空欄を埋めてください．
		 */
		Iterator<String> newMIte = browser.getMenuMap().values().iterator();
		while(newMIte.hasNext()) {
			String menu = newMIte.next();
			System.out.println(menu);
		}
		System.out.println();
		
		//Pluginの機能を呼び出す．
		browser.process();

	}

}
