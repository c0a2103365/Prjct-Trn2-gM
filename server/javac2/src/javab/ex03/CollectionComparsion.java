package javab.ex03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class CollectionComparsion {
    public static void main(String[] args) {
        int NUM=50000;
        ArrayList<String> aList=new ArrayList<String>();

        Vector<String> vList=new Vector<String>();

        LinkedList<String> lList=new LinkedList<String>();

        long addstart_array=System.currentTimeMillis();
        for(int i=0;i<NUM;i++){
            aList.add("工科 太郎"+i);
        }
        long addend_array=System.currentTimeMillis();
        long addtime_array=addend_array-addstart_array;

        long addstart_vector=System.currentTimeMillis();
        for(int i=0;i<NUM;i++){
            vList.add("工科 太郎"+i);
    }
    long addend_vector=System.currentTimeMillis();
    long addtime_vector=addend_vector-addstart_vector;

    long addstart_link=System.currentTimeMillis();
    for(int i=0;i<NUM;i++){
        lList.add("工科 太郎"+i);
    }
    long addend_link=System.currentTimeMillis();
    long addtime_link=addend_link-addstart_link;
    System.out.println("【追加】/ArrayList:"+addtime_array+
        "ms/Vector:"+addtime_vector+"ms/LinkedList:"+
        addtime_link+"ms");

        long schstart_array=System.currentTimeMillis();
        for(int i=0;i<NUM;i++){
            aList.get(i);
        }
        long schend_array=System.currentTimeMillis();
        long schtime_array=schend_array-schstart_array;

        long schstart_vector=System.currentTimeMillis();
        for(int i=0;i<NUM;i++){
            vList.get(i);
        }
        long schend_vector=System.currentTimeMillis();
        long schtime_vector=schend_vector-schstart_vector;

        long schstart_link=System.currentTimeMillis();
        for(int i=0;i<NUM;i++){
        lList.get(i);
        }
        long schend_link=System.currentTimeMillis();
        long schtime_link=schend_link-schstart_link;

        System.out.println("【検索】/ArrayList:"+schtime_array+
            "ms/Vector:"+schtime_vector+"ms/LinkedList"+
            schtime_link+"ms");
    }
}
