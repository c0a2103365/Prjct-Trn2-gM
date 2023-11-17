package javab.ex04;

import java.util.Comparator;

public class HeightComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
			Kadai2Bean m1 = (Kadai2Bean)o1;
			Kadai2Bean m2 = (Kadai2Bean)o2;

			//Weightの昇順となるようにする．
			if(m1.getHeight() >= m2.getHeight()){
				/**
				 * ポイント
				 * heightの降順となるように，ポイント: 1 or -1を返してください．
				 */
			    return -1;

			}else{
				/**
				 * ポイント
				 * heightの降順となるように，ポイント: 1 or -1を返してください．
				 */
			    return 1;
			}
	}


}
