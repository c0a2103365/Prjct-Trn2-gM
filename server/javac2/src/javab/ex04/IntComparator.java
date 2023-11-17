package javab.ex04;

import java.util.Comparator;

public class IntComparator implements Comparator{
	@Override
	public int compare(Object o1, Object o2) {
		// TODO 自動生成されたメソッド・スタブ
        Integer m1 = (Integer)o1;
        Integer m2 = (Integer)o2;
        //大きい順に並び替える
        //ちなみに，return値の符号を逆にすれば，小さい順となる．
        if(m1.intValue() >= m2.intValue()){
            return -1;

        }else{
            return 1;
        }
	}
}
