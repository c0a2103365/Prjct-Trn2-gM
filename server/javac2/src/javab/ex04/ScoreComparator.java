package javab.ex04;

import java.util.Comparator;

public class ScoreComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO 自動生成されたメソッド・スタブ
        Student m1 = (Student)o1;
        Student m2 = (Student)o2;
        //大きい順に並び替える
        //ちなみに，return値の符号を逆にすれば，小さい順となる．
        if(m1.getScore() >= m2.getScore()){
            return -1;

        }else{
            return 1;
        }
	}



}