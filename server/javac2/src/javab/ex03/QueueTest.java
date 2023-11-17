package javab.ex03;

import java.util.LinkedList;

public class QueueTest {

	public static void main(String[] args) {
		LinkedList<String> lList = new LinkedList<String>();
		for(int i=0;i<10000;i++) {
			lList.add("工科太郎"+i);
		}
		//この段階での要素数
		System.out.println("要素数:"+lList.size());

		//キューとして見た場合の，最後に追加
		lList.offer("新規追加要素");
		System.out.println("最後:"+lList.getLast() + "/要素数:"+lList.size());

		//キューとして見た場合の，最初の要素をとってくる．
		//取得して，要素が削除される．
		String val = lList.poll();
		System.out.println("取得した要素:"+val + "/要素数:"+lList.size());

	}

}
