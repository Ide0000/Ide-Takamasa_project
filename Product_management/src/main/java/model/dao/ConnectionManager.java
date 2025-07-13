package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//データベース接続を管理するクラス

public class ConnectionManager {
	private static final String URL = "jdbc:mysql://localhost:3306/training_db";
	private static final String USER = "root";
	private static final String PASSWORD = "c84-tsa5TKMS!";

	//データベースへの接続を取得して返します。
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		//JDBCドライバのロード
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

}
