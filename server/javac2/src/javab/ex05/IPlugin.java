package javab.ex05;

public interface IPlugin {
	
	/**
	 * メニューに項目を追加するメソッドです．
	 * @param key
	 * @param value
	 */
	public void addMenu();
	
	
	public String getMethodName();
	
	/**
	 * ブラウザの参照をもたせる
	 * @param browser
	 */
	public void setBrowser(Browser browser);
	
	

	
	
	
	

}
