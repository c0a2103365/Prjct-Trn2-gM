package javab.ex04;

import java.util.Comparator;

public class WeightComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
			Kadai1Bean m1 = (Kadai1Bean)o1;
			Kadai1Bean m2 = (Kadai1Bean)o2;
			
			//Weightの昇順となるようにする．
			if(m1.getWeight() >= m2.getWeight()){
				/**
				 * ポイント
				 * weightの昇順となるように，ポイント: 1 or -1を返してください．
				 */
			    return 1;
			
			}else{
				/**
				 * ポイント
				 * weightの昇順となるように，ポイント: 1 or -1を返してください．
				 */
			    return -1;
			}
	}
	

}
