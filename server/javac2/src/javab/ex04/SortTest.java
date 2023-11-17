package javab.ex04;

import java.util.Iterator;
import java.util.TreeSet;

public class SortTest {

	public static void main(String[] args) {
		
		/**
		 * TreeSetのインスタンス化時に，指定のComparatorを渡しておく．
		 * 今回は，点数の高い順にソートされるようにしておく．
		 */
		TreeSet<Student> tSet = new TreeSet<Student>(new ScoreComparator());
		
		//Studentオブジェクトを格納する．
		for(int i=0;i<5;i++) {
			Student s = new Student(i, "工科太郎"+i, (int)(Math.random()*100));
			tSet.add(s);
		}
		
		//あとは出力
		Iterator<Student> sIte = tSet.iterator();
		while(sIte.hasNext()) {
			Student s = sIte.next();
			System.out.println("ID:"+s.getId()+"/Name:"+s.getName()+ "/点数:"+s.getScore());
		}
		
		

	}

}
