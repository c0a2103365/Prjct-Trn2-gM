package ex01;

import java.util.LinkedList;

public class Ex1Main {
    public static void main(String[] args){
        LinkedList<Ex1Thread> list =  new LinkedList<Ex1Thread>();
        for(int i=0;i<10;i++){
            //Ex1Threadをインスタンス化する．
            Ex1Thread th = new Ex1Thread(i, 0);
            //listへaddする．
            list.add(th);
        }

        for(int i=0;i<10;i++){
            Ex1Thread th = list.get(i);
            th.myList = list;
             //あとは，それぞれのスレッドを開始させる．
            Thread t = new Thread(th);
            t.start();
        }
       

 

    }
   
}
