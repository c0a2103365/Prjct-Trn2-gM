package javab.課題解答.課題2;

/**
 * 消防車のクラスです．
 * @author kanemih
 */
public class FireEngine extends Car implements iFire {



	public FireEngine(String driverName, String carType) {
		super(driverName, carType);
		// この順番になっていること．
		this.carType = "消防車";


	}

	@Override
	public void discharge() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void siren() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void bridge() {
		// TODO 自動生成されたメソッド・スタブ

	}



}
