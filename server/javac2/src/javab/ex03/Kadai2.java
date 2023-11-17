package javab.ex03;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ArrayList, Vectorの演習【やや難しい】
 * あなたは，到着空港で待っている人です．
 *
 * まず，固定数の乗客を乗せます．そして，乗客が持っている荷物を取り出して
 * 飛行機の荷物リストのキューへ追加します．そして離陸します．
 * 着陸したら，乗客をまずは飛行機からおろします（飛行機の乗客リストを空にする）．
 * そして，飛行機の荷物キューからpollしていって，それらの荷物を，持つべき乗客に再設定します．
 * ポイント:
 * まずは
 * java.util.ArrayListとjava.util.Iterator の2つをimportしてください．
 *
 */
public class Kadai2 {

	public static void main(String[] args) {
		/**
		 * ポイント: 自分の情報に変えてください
		 */
		System.out.println("学籍番号:C0A21033:" + "氏名:金光駿弥");
		/**
		 * 乗客のリスト
		 */
		ArrayList<Passenger> pList = new ArrayList<Passenger>();

		//まずは飛行機をインスタンス化
		TeuAirPlane plane = new TeuAirPlane("ボーイング工科大");

		/**
		 * 0人の乗客をインスタンス化して，飛行機に乗せる．
		 * -
		 * - 飛行機であるplaneのtakePassengerメソッドによって，
		 *   ↑でインスタンス化したPassengerを飛行機に乗せてあげてください．
		 *
		 *
		 */
		for(int i=0;i<10;i++) {
			Luggage l = new Luggage(i, i*2);
			/**
			 * ポイント: Passengerをインスタンス化してください．引数は，i, "Kouka"+i, l の3つです．
			 */
			Passenger p = new Passenger(i,"Kouka"+i,l);
			//プログラム内で扱う乗客のリストに追加
			pList.add(p);
			/**
			 * ポイント:
			 * 飛行機であるplaneのtakePassengerメソッドによって，
			 *   ↑でインスタンス化したPassengerを飛行機に乗せてあげてください．
			 *   実は，takePassengerメソッドには，荷物を飛行機内のキューに入れる処理も入っています．
			 */
			plane.takePassenger(p);

		}
		System.out.println("10人の乗客を乗せました(ID: 0(name:Kouka0) - 9(name:Kouka9))");
		System.out.println("では，離陸します．お気をつけください．");
		//とりあえず2秒(=2000ms)だけ飛ぶ．
		plane.fly(2000);


		System.out.println("乗客の数は"+plane.getPasList().size()+"人です．");
		//キーボードで入力を促す仕組みです．
        System.out.println("全ての荷物を乗客へ返します．結果は↓．");
        for(int i=0;i<10;i++) {
        	/**
        	 * ポイント:
        	 * 荷物リストの先頭を取り出す．先頭を「取り出す」メソッドは何かを考えて書いてください．
        	 * ※ get(0)や，elementメソッド以外のメソッドを使ってください．
        	 */
        	Luggage l = plane.getLugList().get(i);

			//pListのイテレータを取得
			Iterator<Passenger> pIte = pList.iterator();
			Passenger targetPassenger = null;
           	/**
        	 * ポイント:
        	 * pIteが，まだ次がある場合，という処理をwhileのカッコ内に書いてください．
        	 */
        	while(pIte.hasNext()) {
        		targetPassenger = pIte.next();
        		/**
        		 * ポイント: 乗客の乗客IDと荷物lの所有者IDが等しければ，という条件を書いてください．
        		 */
        		if(targetPassenger.getpID()==l.getOwnerID()) {
        			/**
        			 * ポイント: 乗客のmyLuggageに，lをセットする処理を書いてください．
        			 */
        			targetPassenger.setMyLuggage(l);
        			System.out.println("荷物:"+l.getOwnerID() + "->" +targetPassenger.getName());
        			break;
        		}
        	}
        }
	}
}
