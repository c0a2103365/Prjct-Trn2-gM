package javab.ex06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * 内容: pokemon.datの中で，
 * - カンマ(,)で区切られた要素の1番目(1から数えて1番目）の要素（名前）が「ピカ」を含み，
 * または
 * - カンマ(,)で区切られた要素の5番目(1から数えて5番目）の要素が「どく」に完全一致する
 * 行を特定して，その行の1~5のすべての要素をkadai2.txtに書き出してください．
 * @author kanemih
 *
 */
public class Kadai2 {

	public static void main(String[] args) {
		try{

			FileReader fr = new FileReader("pokemon.dat");
			BufferedReader br = new BufferedReader(fr);
			/**
			 * ポイント:
			 * FileWriterのインスタンス化時に，"kadai2.txt"に書き込むようにしてください．
			 */
			     FileWriter fw = new FileWriter("kadai2.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			/**
			 * ポイント: kadai2.txtの先頭行に，学籍番号と氏名を書き込んでください．
			 *
			 *
			 */
			pw.println("学籍番号: C0A21033/氏名: 金光駿弥");
			for(int i = 0; i < 251; i++){
				String str= br.readLine();
				/**
				 * ポイント:
				 * StringTokenizerクラスをインスタンス化してください．
				 * 第一引数を一行の文字列であるstr，第二引数を","としてください．
				 *
				 */
				StringTokenizer st = new StringTokenizer(str,",");

				/**
				 * ポイント:
				 * strの最初の要素を取得してください．
				 *
				 */
				String name = st.nextToken();
				/**
				 * ポイント: nameに「ピカ」が含まれている場合，という
				 * if文にしてください．ex02のIndexTestを参考に．
				 *
				 */
				if(name.indexOf("ピカ") != -1) {

					//この時点で，valには5番目の要素が格納されている．
					pw.println(str);

				}
				String val = null;

				while(st.hasMoreElements()) {
					/**
					 * ポイント: stの次のトークンをvalへ代入させるようにしてください．
					 * つまり，ここでは，次のトークンがある間，次のトークンを代入して，
					 * 最終的には5番目の要素がvalに格納されてbreakする仕組みです．
					 */
					val = st.nextToken();
				}
				/**
				 * ポイント: 5番目の要素をもつvalが「どく」と完全一致する場合は，というif文を
				 * 完成させてください．==演算子は使わないでください．
				 */
				if(val.equals("どく")) {
					pw.println(str);
				}

			}
			br.close();
			pw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}


	}

}
