package javab.ex03;

import java.util.Iterator;
import java.util.LinkedList;


public class ListLoopTest {

	public static void main(String[] args) {
		LinkedList<String> lList = new LinkedList<String>();
		//まずは要素を追加
		for(int i=0;i<10000;i++) {
			lList.add("工科太郎"+i);
		}
		
		long st_time = System.currentTimeMillis();
		//for文にて，index値で要素を取得する．
		//毎回，0番目から走査している．
		for(int i=0;i<10000;i++) {
			lList.get(i);
		}
		long end_time = System.currentTimeMillis();
		long time = end_time - st_time;
		
		
		//iteratorにて要素を取得する．
		Iterator<String> sIte = lList.iterator();
		long st_time2 = System.currentTimeMillis();
		//iteratorによって，前回のindexからの走査となる．
		while(sIte.hasNext()) {
			String str = sIte.next();
		}
		long end_time2 = System.currentTimeMillis();
		long time2 = end_time2 - st_time2;
		System.out.println("For文:"+time + "ms/iterator文:"+time2+"ms");	
	}
}
