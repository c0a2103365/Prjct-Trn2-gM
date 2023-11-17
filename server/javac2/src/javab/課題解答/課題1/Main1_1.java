package javab.課題解答.課題1;

public class Main1_1 {

	public static void main(String[] args) {
		//インスタンス化する．
		Car car = new Car("工科太郎", "SUV");
		//値の変更
		car.setDriverName("新工科太郎");
		car.setCarType("スポーツカー");

		//値の出力
		System.out.println(car.getDriverName());
		System.out.println(car.getCarType());



	}

}
