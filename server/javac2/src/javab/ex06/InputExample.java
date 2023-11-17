package javab.ex06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class InputExample{
	public static void main(String[] args) throws IOException{
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		System.out.println("何か入力してください");
		String str1 = br.readLine();

		System.out.println("もう一声");
		String str2 = br.readLine();

		System.out.println("入力された文字列は，"+str1+" "+str2+"です");
	}
}
