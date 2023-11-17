package javab.ex04;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class MapSortTest {

	public static void main(String[] args) {
		//HashMapをインスタンス化する．
		HashMap<Integer, Student> map = new HashMap<Integer, Student>();
		//とりあえず格納
		for(int i=0;i<5;i++) {
			Student s = new Student(i, "工科太郎"+i, (int)(Math.random()*100));
			map.put(new Integer(s.getId()),s);
		}
		//Mapのvalue部を，list化する．
		LinkedList<Student> stList = new LinkedList<Student>(map.values());
		
		//Collectionsクラスのsortメソッドを使う．sort(List, Comparator)という形式．
		//Collectionsクラスは，各種アルゴリズムをstaticメソッドとして提供している．
		//ここでは，点数(score)の降順でソートする．
		Collections.sort(stList, new ScoreComparator());
		
		Iterator<Student> stIte = stList.iterator();
		while(stIte.hasNext()) {
			Student st = stIte.next();
			System.out.println("ID:"+st.getId() + "/Name:"+st.getName() + "/Score:"+st.getScore());
		}
	}
}
