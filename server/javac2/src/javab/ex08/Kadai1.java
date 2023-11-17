package javab.ex08;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Kadai1 {

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
			String db_id = "root";
			// パスワードを取得
			String db_password = "";
			// SQL文の作成
			String sql = "SELECT * FROM employees WHERE employee_id=100";

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
			// SQL実行準備
			stmt = con.prepareStatement(sql);
			// 実行結果取得
			rs = stmt.executeQuery();


			// データがなくなるまで(rs.next()がfalseになるまで)繰り返す
			while (rs.next()) {
				String id = rs.getString("employee_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getNString("last_name");
				System.out.println(id + ":" + first_name + ":"+last_name);
			}

			String sql2 = "SELECT * FROM employees WHERE employee_id > 100000";
			/**
			 * ポイント: それぞれsql2を実行させるように，conとstmtを用いて，stmtとrsに
			 * それぞれ適切なものを代入させるように処理書いてください．(2行文です）．
			 */
			stmt =con.prepareStatement(sql2);
			rs = stmt.executeQuery();

			/**
			 * ポイント:
			 * sql2のSQL文の実行結果，つまりレコードが無ければ，という条件をifのカッコの中に書いてください．
			 * ヒント: ビックリマーク
			 */
			if(!rs.next()) {
				//結果が無ければ，無しと出力
				System.out.println("無し");
			}else {

				System.out.println("有る");
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
