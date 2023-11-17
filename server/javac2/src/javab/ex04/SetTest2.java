package javab.ex04;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest2 {

	public static void main(String[] args) {

		Student s1 = new Student(1, "test", 100);
		Student s2 = new Student(1, "test", 100);
		Student s3 = new Student(1, "test2", 100);

		HashSet<Student> set = new HashSet<Student>();

		set.add(s1);
		set.add(s2);
		set.add(s3);

		Iterator<Student> sIte = set.iterator();
		while(sIte.hasNext()) {
			Student s = sIte.next();
			System.out.println(s.getId() + "/"+s.getName() + "/"+s.getScore());
		}
		System.out.println("------同一参照オブジェクトを追加した場合（3+1コ):");

		//では，同じ参照のオブジェクトを追加してみる．
		set.add(s1);
		//そして出力してみる．
		Iterator<Student> sIte2 = set.iterator();
		while(sIte2.hasNext()) {
			Student s = sIte2.next();
			System.out.println(s.getId() + "/"+s.getName() + "/"+s.getScore());
		}
		System.out.println("-------文字列の場合(もともとは3つ）");

		HashSet<String> set2 = new HashSet<String>();
		set2.add("test");
		set2.add("test2");
		set2.add("test");
		Iterator<String> sIte3 = set2.iterator();
		while(sIte3.hasNext()) {
			String s = sIte3.next();
			System.out.println(s);
		}

	}

}
