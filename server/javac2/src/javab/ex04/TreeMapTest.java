package javab.ex04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;


/**
 * キーの昇順によるソートのサンプル
 * 
 *
 */
public class TreeMapTest {

	public static void main(String[] args) {
		
		System.out.println("TreeMapからの直接のキーのソート");

		/**
		 * 直接，TreeMapにてソート済みで保持させる
		 *
		 */
		TreeMap<Integer, Student> map = new TreeMap<Integer, Student>();
		
		//とりあえず格納
		for(int i=0;i<5;i++) {
			Student s = new Student(i, "工科太郎"+i, (int)(Math.random()*100));
			map.put(new Integer(s.getId()),s);
		}
		
		//出力
		Iterator<Student> tIte = map.values().iterator();
		while(tIte.hasNext()) {
			Student s = tIte.next();
			System.out.println("id:"+s.getId() + "/name:"+s.getName() + "/点数:"+s.getScore());
		}
		
		
		System.out.println("HashMap->TreeMapでのキーのソート");
		/**
		 * HashMapからのソート．
		 * 結局，TreeMapにわたす必要がある．
		 */
		HashMap<Integer, Student> hMap = new HashMap<Integer, Student>();
		
		//とりあえず格納
		for(int i=0;i<5;i++) {
			Student s = new Student(i, "工科太郎"+i, (int)(Math.random()*100));
			hMap.put(new Integer(s.getId()),s);
		}
		//ソートする．
		TreeMap<Integer, Student> tMap = new TreeMap<Integer, Student>(hMap);
		//出力
		Iterator<Student> hIte = map.values().iterator();
		while(hIte.hasNext()) {
			Student s = hIte.next();
			System.out.println("id:"+s.getId() + "/name:"+s.getName() + "/点数:"+s.getScore());
		}
		

	}

}
