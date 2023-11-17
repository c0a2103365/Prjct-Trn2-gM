package javab.ex07;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DBTest {

	public static void main(String[] args) {
		// 認証情報を読み込むために必要．
		Properties prop = null;

		// 接続用オブジェクト
		Connection con = null;

		// SQL文を保持するためのオブジェクト
		PreparedStatement stmt = null;

		// DBからの取得結果を格納するオブジェクト
		ResultSet rs = null;

		try {

			// 認証ファイルから，DB接続用IDを取得．
			String db_id = "root";
			// パスワードを取得
			String db_password = "";

			// SQL文の用意
			String sql = "SELECT * FROM employees";
			// JDBCドライバのロード
			Class.forName("com.mysql.cj.jdbc.Driver");
			// DBの接続
			con = DriverManager.getConnection(
					"jdbc:mysql://projava2.cloud.cs.priv.teu.ac.jp:3306/javab_db?serverTimezone=JST",
					db_id, db_password);

			// SQL実行準備
			stmt = con.prepareStatement(sql);

			// SQL実行
			rs = stmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("employee_id");
				String name = rs.getNString("first_name");

				System.out.println("id:" + id + "/name:" + name);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
