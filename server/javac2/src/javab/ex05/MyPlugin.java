package javab.ex05;

import java.util.LinkedHashMap;

public class MyPlugin implements IPlugin{

	private Browser browser;

	public MyPlugin() {

	}

	@Override
	public void addMenu() {
		LinkedHashMap<String, String> menu = this.browser.getMenuMap();
		/**
		 * ポイント:
		 * menuに，
		 * key: "myplugin_01"
		 * value: "MyPluginのメニュー"
		 * を追加させてください．
		 */
		menu.put("myplugin_01","MyPluginのメニュー");
	}

	@Override
	public String getMethodName() {
		return "showMessage";
	}

	@Override
	public void setBrowser(Browser browser) {
		this.browser = browser;

	}

	public void showMessage() {
		System.out.println("Pluginでのメッセージ表示機能が呼ばれました．");
	}

}
