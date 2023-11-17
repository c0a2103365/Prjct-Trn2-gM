package javab.ex06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class InputSuchi{
	public static void main(String[] args)throws IOException {
		BufferedReader br =
		new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("何個の数値の平均値を求めますか？");
		String str = br.readLine();
		
		int num = Integer.parseInt(str);
		System.out.println(num+"個のint型数値を入力してください");
		
		int sum = 0;
		for(int i = 0; i < num; i++){
			str = br.readLine();
			sum += Integer.parseInt(str);
		}
		System.out.println("平均値は，" +(double)sum/num+"です");
	}
}
