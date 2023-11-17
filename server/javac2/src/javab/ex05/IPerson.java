package javab.ex05;

public interface IPerson {

	/**
	 * 何らかの挨拶を出力する
	 */
	public void sayHello();
	
	/**
	 * 多分，年齢を言う．嘘の年齢を言うかも
	 * @return
	 */
	public int getAge();
	
	/**
	 * 年齢を教えてあげるメソッド
	 * @param age
	 */
	public void setAge(int age);
	
	/**
	 * 名前を取得
	 * @return
	 */
	public String getName();
	
	/**
	 * 名前を設定する．
	 * @param name
	 */
	public void setName(String name);
}
