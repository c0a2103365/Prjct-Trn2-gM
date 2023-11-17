package javab.ex05;

import java.lang.reflect.Method;

public class ReflectionTest {

	public static void main(String[] args) {
		try {
			Class<?> classObj = Class.forName("javab.ex05.Student");
			Object instance = classObj.newInstance();
			Method[] methods = classObj.getDeclaredMethods();
			int len = methods.length;
			try {
				//メソッド情報を出力
				for(int i=0;i<len;i++) {
					Method m = methods[i];
					//特定の名前のメソッドを呼び出す．
					//もしsetScoreメソッドであれば，invokeによって値をセットする．
					if(m.getName().equals("setScore")) {
						//値をセットする．
						m.invoke(instance, 55);
					}
					//もしgetScoreメソッドであれば，invokeによって値を取得する．
					if(m.getName().equals("getScore")) {
						System.out.println("[invoke]:getScore値:"+m.invoke(instance));
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
