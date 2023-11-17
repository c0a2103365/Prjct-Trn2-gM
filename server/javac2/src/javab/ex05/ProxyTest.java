package javab.ex05;

import java.lang.reflect.Proxy;

/**
 * "Person"という名前だけでPersonの機能を呼び出し，かつPersonをいじらずに
 *  Personのメソッド前後に好きな処理を加える場合．
 * @author kanemih
 *
 */
public class ProxyTest {

	public static void main(String[] args) {
		try {
			//Personの名前だけでインスタンスを取得する．
			Class<?> classObj = Class.forName("javab.ex05.Person");
			Object instance = classObj.newInstance();
			
			//Personの代理処理をするオブジェクトを生成する．
			MyHandler handler = new MyHandler(instance);
			
			//proxy経由で，IPerson実装クラスのオブジェクトを取得する．
			//これにより，pの処理には必ずhandlerを経由することになる．
			IPerson p = (IPerson)Proxy.newProxyInstance(
					classObj.getClassLoader(),
					new Class[]{ IPerson.class },
					handler);

			System.out.println("@ProxyTest:setAge");
			p.setAge(55);
			System.out.println("@ProxyTest:getAge");
			System.out.println("年齢:"+p.getAge());

		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
