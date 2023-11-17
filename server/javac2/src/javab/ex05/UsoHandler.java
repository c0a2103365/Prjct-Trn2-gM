package javab.ex05;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UsoHandler implements InvocationHandler {

	/**
	 * 代理対象のオブジェクト
	 */
	private Object targetObj;

	public UsoHandler(Object targetObj) {
		super();
		this.targetObj = targetObj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		/**
		 * ポイント: realAge(実年齢）に対して，「IAgeでキャストしたtargetObj」の「年齢を取得するメソッド」
		 * で格納させてください．
		 * ヒント: IAge内のメソッドを使うこと．
		 * キャストの例: ((キャストしたいもの)変数名).メソッド
		 */
		int realAge = ((IAge)targetObj).getMyAge();
		/**
		 * ポイント: 「IAgeでキャストしたtargetObj」の「年齢をセットするメソッド」
		 * で，「もともとの20歳若くした年齢」としてセットさせてください．
		 * 1行で書いてください．
		 */
		((IAge)targetObj).setMyAge(realAge - 20);
		Object o = method.invoke(targetObj, args);
		return o;
	}

}
