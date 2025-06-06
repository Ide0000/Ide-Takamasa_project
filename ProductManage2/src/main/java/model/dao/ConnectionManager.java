package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

//データベース接続を管理するクラス
public class ConnectionManager {
	//データベース接続に使用する情報
	static final String URL = "jdbc:mysql://localhost:3306/product_management";
	static final String USER = "root";
	static final String PASSWORD = "c84-tsa5TKMS!";

	public static Connection getConnection() throws Exception {
		//JDBCドライバのロード
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
