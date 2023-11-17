package javab.ex04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {

	public static void main(String[] args) {

		//HashMap
		HashMap<Integer, String> hMap = new HashMap<Integer, String>();
		hMap = (HashMap<Integer, String>)MapTest.createMap(hMap);
		//値のイテレータを取得
		Iterator<String> hIte = hMap.values().iterator();
		System.out.println("HashMap:");
		while(hIte.hasNext()) {
			String val = hIte.next();
			System.out.println(val);
		}

		//LinkedHashMap
		LinkedHashMap<Integer, String> lMap = new LinkedHashMap<Integer, String>();
		lMap = (LinkedHashMap<Integer, String>)MapTest.createMap(lMap);
		//値のイテレータを取得
		Iterator<String> lIte = lMap.values().iterator();
		System.out.println("LinkedHashMap:");
		while(lIte.hasNext()) {
			String val = lIte.next();
			System.out.println(val);
		}

		//TreeMap
		TreeMap<Integer, String> tMap = new TreeMap<Integer, String>();
		tMap = (TreeMap<Integer, String>)MapTest.createMap(tMap);
		//値のイテレータを取得
		Iterator<String> tIte = tMap.values().iterator();
		System.out.println("TreeMap:");
		while(tIte.hasNext()) {
			String val = tIte.next();
			System.out.println(val);
		}
	}

	/**
	 * データを作成するためのstaticメソッド
	 * @return
	 */
	public static Map<Integer, String> createMap(Map<Integer, String> map){
		map.put(12, "工科12");
		map.put(2, "工科2");
		map.put(3, "工科3");
		map.put(4, "工科4");
		map.put(5, "工科5");

		return map;

	}

}
