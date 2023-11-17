package javab.ex02;

import java.util.StringTokenizer;

public class TokenTest {

	public static void main(String[] args) {
		String line =  "ぶどう,みかん,りんご,すいか,梨";
		//半角カンマ","区切りで文字列を分割する
        StringTokenizer st = new StringTokenizer(line, ",");
        int idx = 0;
        //分割されたものに対して順に要素を取得するためのループ
        while (st.hasMoreTokens()) {
            // 各要素を取得する．
            String element = st.nextToken();
            System.out.println(idx+"番目:"+ element);
            idx++;

        }

	}

}
