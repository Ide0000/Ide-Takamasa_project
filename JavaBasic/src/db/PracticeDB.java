package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PracticeDB {
	public static void main(String[] args) {
		final String URL = "jdbc:mysql://localhost:3306/product_management";//MySQLのDB名
		final String USER = "root"; // MySQLのユーザー名
		final String PASSWORD = "c84-tsa5TKMS!"; // MySQLのパスワード

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			//DBに接続
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			//ステートメントを生成
			statement = connection.createStatement();
			//SQLを実行　
			resultSet = statement.executeQuery("SELECT * FROM products");
			System.out.println("DB接続成功！\n-- productsテーブルの全ての商品情報を表示 --");
			//データを表示
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int price = resultSet.getInt("price");
				int stock = resultSet.getInt("stock");
				int categoryId = resultSet.getInt("category_id");

				System.out.println("id: " + id);
				System.out.println("name: " + name);
				System.out.println("price: " + price);
				System.out.println("stock: " + stock);
				System.out.println("category_id: " + categoryId);
				System.out.println(); 
			}
		} catch (SQLException e) {
			//エラー処理
			System.out.println("DB接続失敗");
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}


