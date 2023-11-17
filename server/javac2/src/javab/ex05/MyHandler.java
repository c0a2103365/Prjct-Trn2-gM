package javab.ex05;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理に処理をやってあげるクラス(proxy)です．
 * @author kanemih
 *
 */
public class MyHandler implements InvocationHandler {
	
	/**
	 * 代理してあげる対象のオブジェクト
	 */
	private Object targetObj;
	
	/**
	 * コンストラクタ
	 * @param obj
	 */
	public MyHandler(Object obj) {
		this.targetObj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	    // 対象のメソッドを実行する前に処理を追加.
        System.out.println("@MyProxy: ****"+method.getName()+"メソッド呼び出し前");
        // 対象のメソッドを呼び出す.
        Object o = method.invoke(targetObj, args);
        // 対象のメソッドを実行した後に処理を追加.
        System.out.println("@MyProxy: ****"+method.getName()+"メソッド呼び出し後");
        return o;
	}

}
