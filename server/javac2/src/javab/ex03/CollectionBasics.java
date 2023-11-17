package javab.ex03;

import java.util.ArrayList;

public class CollectionBasics {

	public static void main(String[] args) {
		/**ArrayList**/
		ArrayList<String> aList = new ArrayList<String>();
		//追加
		aList.add("工科太郎");
		System.out.println("現在の値:"+aList.get(0));
		
		//更新
		aList.set(0,  "新しい値");
		System.out.println("現在の値(2): "+aList.get(0));
		
		//取得
		String val1 = aList.get(0);
		
		//削除
		aList.remove(0);
		System.out.println("要素数:"+aList.size());
		
		

		
	}

}
