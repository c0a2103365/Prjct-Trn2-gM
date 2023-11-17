package javab.ex05;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Browser {

	/**
	 * メニューリスト<キー, メニュー名前>
	 */
	private LinkedHashMap<String, String> menuMap;

	/**
	 * プラグインのリスト
	 */
	private LinkedList<IPlugin> pList;

	public Browser() {
		//メニュの初期値を設定する．最初は3つのメニューがあるものとする．
		this.menuMap = new LinkedHashMap<String, String>();
		menuMap.put("01", "ファイル");
		menuMap.put("02", "お気に入り");
		menuMap.put("03", "編集");

		//pListは空っぽとする．
		this.pList = new LinkedList<IPlugin>();
	}

	/**
	 * プラグインのクラス名(full name)から，クラスをロードして追加する．
	 * @param pName
	 */
	public void addPlugin(String pName) {
		try {
			/**
			 * ポイント: pNameという文字列から，Classを取得するようにメソッド名を埋めてください．
			 */
			Class<?> classObj = Class.forName(pName);
			IPlugin plugin = (IPlugin)classObj.newInstance();
			//自分(Browser)自身をpluginにセットさせるように，setBrowserの引数を指定してください．
			plugin.setBrowser(this);
			//pluginのメニューを追加
			plugin.addMenu();
			/**
			 * ポイント: pListに，pluginを追加させてください．
			 * offerではないほうです．
			 */
			this.pList.add(plugin);

		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 各プラグインのメソッドを呼び出します．
	 */
	public void process() {
		try {

			Iterator<IPlugin> pIte = this.pList.iterator();
			while(pIte.hasNext()) {
				IPlugin plugin = pIte.next();
				/**
				 * ポイント: pluginの何かから，getDeclaredMethods()によってメソッド配列
				 * を格納させてください．空欄を埋めてください．
				 */
				Method[] methods = plugin.getClass().getDeclaredMethods();
				int len  = methods.length;
				for(int i=0;i<len;i++) {
					/**
					 * ポイント:
					 * pluginのgetMethodName()と等しいならば，という条件を完成させてください．
					 * 参照が等しいかではなく，値が等しいか，というようにしてください．
					 */
					if(methods[i].getName()==plugin.getMethodName()) {
						methods[i].invoke(plugin);
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	public LinkedHashMap<String, String> getMenuMap() {
		return menuMap;
	}

	public void setMenuMap(LinkedHashMap<String, String> menuMap) {
		this.menuMap = menuMap;
	}

	public LinkedList<IPlugin> getpList() {
		return pList;
	}

	public void setpList(LinkedList<IPlugin> pList) {
		this.pList = pList;
	}
}
