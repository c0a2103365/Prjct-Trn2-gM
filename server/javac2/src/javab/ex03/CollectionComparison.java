package javab.ex03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class CollectionComparison {

	public static void main(String[] args) {
		/**<~~>は，扱う要素の型を指定しているという意味**/
		int NUM = 50000;
		/**ArrayList**/
		ArrayList<String> aList = new ArrayList<String>();
		
		/**Vector**/
		Vector<String> vList = new Vector<String>();
		/**LikedList**/
		LinkedList<String> lList = new LinkedList<String>();
		
		
		/**追加**/
		
		/**ArrayList**/
		long addstart_array = System.currentTimeMillis();
		for(int i=0;i<NUM;i++) {
			aList.add("工科 太郎"+i);
		}
		long addend_array = System.currentTimeMillis();
		long addtime_array = addend_array - addstart_array;
		
		/**Vector**/
		long addstart_vector = System.currentTimeMillis();
		for(int i=0;i<NUM;i++) {
			vList.add("工科 太郎"+i);
		}
		long addend_vector = System.currentTimeMillis();
		long addtime_vector = addend_vector - addstart_vector;
		
		/**LinkedList**/
		long addstart_link = System.currentTimeMillis();
		for(int i=0;i<NUM;i++) {
			lList.add("工科 太郎"+i);
		}
		long addend_link = System.currentTimeMillis();
		long addtime_link = addend_link - addstart_link;
		System.out.println("【追加】/ArrayList:"+addtime_array + 
				"ms/Vector:"+addtime_vector + "ms/LinkedList:"+
				addtime_link + "ms");
		

		/**検索**/
		
		/**ArrayList**/
		long schstart_array = System.currentTimeMillis();
		for(int i=0;i<NUM;i++) {
			aList.get(i);
		}
		long schend_array = System.currentTimeMillis();
		long schtime_array = schend_array - schstart_array;

		/**Vector**/
		long schstart_vector = System.currentTimeMillis();
		for(int i=0;i<NUM;i++) {
			vList.get(i);
		}
		long schend_vector = System.currentTimeMillis();
		long schtime_vector = schend_vector - schstart_vector;
		
		/**LinkedList**/
		long schstart_link = System.currentTimeMillis();
		for(int i=0;i<NUM;i++) {
			lList.get(i);
		}
		long schend_link = System.currentTimeMillis();
		long schtime_link = schend_link - schstart_link;
		
		System.out.println("【検索】/ArrayList:"+schtime_array + 
				"ms/Vector:"+schtime_vector + "ms/LinkedList:"+
				schtime_link + "ms");	
	}
}
