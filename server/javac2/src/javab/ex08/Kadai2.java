package javab.ex08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * テーブル名を入力してもらって，その一覧を取得する課題です．
 * @author kanem
 *
 */
public class Kadai2 {

	public static void main(String[] args) {
		/**
		 * ポイント: 自分の情報に変えてください
		 */
		System.out.println("学籍番号:C0A21033:" + "氏名:金光駿弥");


		//接続オブジェクト
		Connection con = null;
		//SQL文オブジェクト
		PreparedStatement stmt = null;
		//DB取得結果
		ResultSet rs = null;

		try {

			// SQL文の作成
			String sql = "SELECT * FROM employees where employee_id=?";

			// 認証ファイルから，DB接続用IDを取得．
			String db_id = "root";
			// パスワードを取得
			String db_password = "";

			// JDBCドライバのロード
			Class.forName("com.mysql.cj.jdbc.Driver");

				/**
			 * ポイント:
			 * - 学籍番号下一桁が偶数の人: projava.cloud.cs.priv.teu.ac.jpに接続
			 * - 学籍番号下一桁が奇数の人: projava2.cloud.cs.priv.teu.ac.jpに接続
			 * - 接続ポート番号は3306
			 * - javab_dbというDBを用いる，
			 * となるように，↓のjdbc~の中に情報を埋めてください．
			 */
			// データベース接続
			con = DriverManager.getConnection("jdbc:mysql://projava2.cloud.cs.priv.teu.ac.jp:3306/javab_db?serverTimezone=JST",
					db_id, db_password);

			/**
			 * ポイント:
			 * キーボードから入力を促して，値を取得するように
			 * - InputStreamReaderを適切にインスタンス化してください．
			 * （参考: ex06のInputExample)
			 */
			InputStreamReader is =new InputStreamReader(System.in);
			/**
			 * ポイント:
			 * さらに，BufferedReaderを適切にインスタンス化してください．
			 */
			BufferedReader br =new BufferedReader(is);

			System.out.println("employeesの，employee_idを指定してください: ");
			/**
			 * 入力文字列を取得する．
			 */
			String val = br.readLine();


			// SQL実行準備
			stmt = con.prepareStatement(sql);

			/**
			 * ポイント:
			 * sqlの?のところに値を設定します．
			 * A. 文字列の場合は，stmt.setString(番号, "文字列")
			 * B> 数値の場合は，stmt.setInt(番号, 数値)
			 * になります．「番号」の部分は，1こ目の?なら1, 2こ目の?なら2
			 * というように数値で指定します．
			 *
			 * 今回は,取得文字列をint型へ明示的に変換してください．
			 * ex06の，InputSuchiを参考にしてください．
			 * 1行で，stmt.setXXX(X, XXXXXXX); という感じで表現してください．
			 */
			stmt.setInt(1, Integer.parseInt(val));

			// 実行結果取得
			rs = stmt.executeQuery();

			/**
			 * ポイント:
			 * sqlのSQL文の実行結果，つまりレコードが無ければ，という条件をifのカッコの中に書いてください．
			 */
			if(!rs.next()) {
				//結果が無ければ，無しと出力
				System.out.println("ありません．残念でした．");
				System.exit(1);
			}else {
				String id = rs.getString("employee_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getNString("last_name");
				System.out.println(id + ":" + first_name + ":"+last_name);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("データベースへのアクセスでエラーが発生しました。");
			}
		}


	}

}
