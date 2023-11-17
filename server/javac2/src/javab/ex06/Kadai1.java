package javab.ex06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Kadai1 {

	public static void main(String[] args) {
		try{

			FileReader fr = new FileReader("pokemon.dat");
			BufferedReader br = new BufferedReader(fr);
			/**
			 * ポイント: FileWriterのインスタンス化時に，"kadai1.txt"に書き込むようにしてください．
			 */
			FileWriter fw = new FileWriter("kadai1.txt");

			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			/**
			 * ポイント: kadai1.txtの先頭行に，学籍番号と氏名を書き込んでください．
			 * 
			 * 
			 */
			pw.println("学籍番号: C0A21033/氏名: 金光駿弥");
			for(int i = 0; i < 251; i++){
				String str= br.readLine();
				/**
				 * ポイント: iが偶数である場合，というif文にしてください．
				 */
				if(i%2==0) {
					/**
					 * ポイント: 行の先頭に，1から始まる行番号と，カンマをつけてください．
					 * つまり，
					 * 1, フシギダネ,Bulbasaur,バルバソァー,くさ,どく
					 * 3,フシギバナ,Venusaur,ヴィーナソァー,くさ,どく
					 * 5,.....
					 * というように．kadai1.txtに，StringBufferを使って書き込んでください．
					 * ヒント: int型の数値をStringへ変換する方法: 
					 * String.valueOf(数値)
					 */
					StringBuffer buf = new StringBuffer(String.valueOf(i+1));
					buf.append(",");
					/**
					 * ポイント: 下の引数を埋めてください．
					 */
					buf.append(str);
					pw.println(buf.toString());
				}
			}
			br.close();
			pw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
