package javab.ex04;

import java.util.Iterator;
import java.util.TreeMap;

public class TreeMapTest2 {

	public static void main(String[] args) {
		System.out.println("TreeMapでのComparatorによるkeyのソート");

		/**
		 * 直接，TreeMapにてソート済みで保持させる
		 *
		 */
		TreeMap<Integer, Student> map = new TreeMap<Integer, Student>(new IntComparator());
		
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

	}

}
