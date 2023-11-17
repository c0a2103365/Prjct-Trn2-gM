package javab.課題解答.課題2;

public class Main1_2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Car[] cars = new Car[2];
		//きちんと2つの変数を渡しているかどうか
		cars[0] = new Car("工科太郎1", "BMW");
		cars[1] = new FireEngine("消防士", "バス");
		
		for(int i=0;i<cars.length;i++){
			System.out.println(i+"番目:"+cars[i].getCarType());
		}
		

	}

}
