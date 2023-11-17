package javab.ex02;

public class ExceptionTest {

	public static void main(String[] args) {
		ThrowingClass c = new ThrowingClass(4);
		//setNumメソッドはTestExceptionをthrow宣言
		//しているので，//try-catchで囲む必要がある．
		try {
			c.setNum(4);
			//大きな値をセットする．
			c.setNum(10);

		}catch(TestException e) {
			e.printStackTrace();
		}
		

	}

}
