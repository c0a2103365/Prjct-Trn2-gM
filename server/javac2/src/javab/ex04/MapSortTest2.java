package javab.ex04;

import java.util.Arrays;
import java.util.HashMap;

public class MapSortTest2 {

	public static void main(String[] args) {
		//HashMapをインスタンス化する．
		HashMap<Integer, Student> map = new HashMap<Integer, Student>();
		//とりあえず格納
		for(int i=0;i<5;i++) {
			Student s = new Student(i, "工科太郎"+i, (int)(Math.random()*100));
			map.put(new Integer(s.getId()),s);
		}
		//値たちを配列に変換する．
		Object[] st_array = map.values().toArray();
		
		//あとは，Arrays.sortにわたす．
		Arrays.sort(st_array, new ScoreComparator());
		
		//配列自体がソートされるので，その各要素をfor文で取得．
		int len = st_array.length;
		for(int i=0;i<len;i++) {
			System.out.println("ID:"+((Student)(st_array[i])).getId() +
					"/Name:"+((Student)(st_array[i])).getName() + "/Score:"+((Student)(st_array[i])).getScore());

		}

	}

}
