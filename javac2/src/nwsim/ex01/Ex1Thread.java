package ex01;

import java.util.LinkedList;

public class Ex1Thread implements Runnable{

    public int id;
    public int msgCount;
    public LinkedList<Ex1Thread> myList;
   
    public Ex1Thread(int id, int count){
        this.id = id;
        this.msgCount = count;
       
    }

    public Ex1Thread(int id, int count, LinkedList<Ex1Thread> list){
        this.id = id;
        this.msgCount = count;
        this.myList = list;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(true){
            try{
                Thread.sleep(100);
               
                Ex1Thread t = this.myList.get((int)(Math.random()*10));
                t.addCount();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
       
    }

    public void addCount(){
        this.msgCount++;
        System.out.println("ID:"+ this.id + "/msgCount:"+ this.msgCount);   
    }
   
}
