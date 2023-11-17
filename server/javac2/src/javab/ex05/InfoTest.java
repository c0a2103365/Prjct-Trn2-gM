package javab.ex05;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class InfoTest {

	public static void main(String[] args) {

		Student s = new Student(1, "工科太郎", 50);
		Class c = s.getClass();

		//Studentクラスが持っているメソッドたちを取得
		Method[] methods = c.getDeclaredMethods();
		int len = methods.length;
		try {
			//メソッド情報を出力
			for(int i=0;i<len;i++) {
				Method m = methods[i];
				System.out.println("メソッド名:"+ m.getName()+ "/returnタイプ:"+
				m.getReturnType());
				//特定の名前のメソッドを呼び出す．
				//もしgetScoreメソッドであれば，呼び出す．
				if(m.getName().equals("getScore")) {

					System.out.println("[invoke]:getScore値:"+m.invoke(s));
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}


		//Studentクラスが持っているフィールド変数を取得する．
		Field[] fields = c.getDeclaredFields();
		int fLen = fields.length;
		try {
			for(int i=0;i<fLen;i++) {
				Field f = fields[i];
				System.out.println("フィールド変数:"+f.getName());
				if(f.getName().equals("id")) {
					f.set(s,  100);
				}
			}
			System.out.println("最終的なID:"+s.getId());
		}catch(Exception e) {
			e.printStackTrace();
		}



	}

}
