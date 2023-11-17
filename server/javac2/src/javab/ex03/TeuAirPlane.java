package javab.ex03;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 工科大の飛行機クラス
 * なんかすごい機能でもつけようかと思いましたが，
 * 全く思い浮かばず．
 *
 */
public class TeuAirPlane {

	/**
	 * この飛行機の名前
	 */
	protected String name;

	/**
	 * 乗客リスト
	 */
	protected ArrayList<Passenger> pasList;

	/**
	 * 荷物リスト
	 */
	protected LinkedList<Luggage> lugList;

	/**
	 * コンストラクタ
	 *
	 * @param name 飛行機の名前
	 * @param pasList 乗客リスト
	 * @param lugList 荷物リスト
	 */
	public TeuAirPlane(String name) {

		this.name = name;
		this.pasList = new ArrayList<Passenger>();
		this.lugList = new LinkedList<Luggage>();
	}

	/**
	 * 乗客を一人乗せる．
	 * @param p
	 */
	public void takePassenger(Passenger p) {
		/**
		 * ポイント: pasListにpを追加させてください．
		 * 最後尾に追加，ということです．offerは使わないでください．
		 */
		this.pasList.add(p);

		/**
		 * ポイント: pが持つ荷物を，飛行機の荷物リストのキューへ入れる．
		 * （実際には，キューではないけど，ここではキューとして扱う）
		 * 下記のofferLuggageは2つの引数を取ります．pと，pが持つ荷物の2つです．
		 * この2つの引数を書いてください．
		 *
		 */
		this.offerLuggage(p,p.myLuggage);
	}

	/**
	 * 荷物を，荷物リストのキューへ入れる．
	 * @param l
	 */
	public void offerLuggage(Passenger p, Luggage l) {
		/**
		 * ポイント: 荷物リストにlをofferする処理を書いてください．
		 */
		this.lugList.offer(l);

		/**
		 * ポイント: 乗客のmyLuggageにnullを入れてください．
		 * つまり，自分自身では持っていない状態（飛行機の中にはある）
		 * とする．
		 */
		pasList.add(null);
	}

	public void fly(long time) {
		try {
			System.out.println("乗客の数は"+this.getPasList().size()+"人です．");
			System.out.println("今から"+time + "msの間，飛行します");
			Thread.sleep(time);
			System.out.println("着陸しました.");
			/**
			 * ポイント: 乗客リストを空にする．clear()メソッドを使うこと．
			 */
			this.pasList.clear();
			System.out.println("全乗客が降りました");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Passenger> getPasList() {
		return pasList;
	}

	public void setPasList(ArrayList<Passenger> pasList) {
		this.pasList = pasList;
	}

	public LinkedList<Luggage> getLugList() {
		return lugList;
	}
	public void setLugList(LinkedList<Luggage> lugList) {
		this.lugList = lugList;
	}
}