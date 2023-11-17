package javab.ex02;

public class ThrowingClass {
	private int num;
	
	public ThrowingClass(int inVal) {
		
		this.num = inVal;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num)throws TestException {
		if(num >= 5) {
			throw new TestException("値が大きすぎます");
		}else {
			System.out.println("正しい値です");
			this.num = num;
		}
	}
}
