package javab.ex04;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {

		String[] arStr = {"Tokyo", "Hokkaido", "Okinawa", "Nagano", "Tottori"};
		System.out.println("HashSetの場合:");
		//HashSet
		HashSet<String> hSet = new HashSet<String>();
		for(int i=0;i<5;i++) {
			//同じ値を2回，追加してみる．
			hSet.add(arStr[i]);
			hSet.add(arStr[i]);
		}
		Iterator<String> hIte = hSet.iterator();
		int idx = 0;
		//HashSetは，バラバラの順
		while(hIte.hasNext()) {
			String val = hIte.next();
			System.out.println(idx+"番目:"+val);
			idx++;
		}
		System.out.println("LinkedHashSetの場合:");

		//LinkedHahSet
		LinkedHashSet<String> lSet = new LinkedHashSet<String>();
		for(int i=0;i<5;i++) {
			//同じ値を2回，追加してみる．
			lSet.add(arStr[i]);
			lSet.add(arStr[i]);
		}
		Iterator<String> lIte = lSet.iterator();
		idx = 0;
		//LinkedHashSetは，挿入順
		while(lIte.hasNext()) {
			String val = lIte.next();
			System.out.println(idx+"番目:"+val);
			idx++;
		}
		
		System.out.println("TreeSetの場合:");

		//TreeSet
		TreeSet<String> tSet = new TreeSet<String>();
		for(int i=0;i<5;i++) {
			//同じ値を2回，追加してみる．
			tSet.add(arStr[i]);
			tSet.add(arStr[i]);
		}
		Iterator<String> tIte = tSet.iterator();
		idx = 0;
		//TreeSetは自然順序（辞書順）
		while(tIte.hasNext()) {
			String val = tIte.next();
			System.out.println(idx+"番目:"+val);
			idx++;
		}
		
	}

}
