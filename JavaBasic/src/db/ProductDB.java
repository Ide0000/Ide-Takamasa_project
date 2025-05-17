package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductDB {
	private static final String URL = "jdbc:mysql://localhost:3306/product_management";//MySQLのDB名
	private static final String USER = "root";// MySQLのユーザー名
	private static final String PASSWORD = "c84-tsa5TKMS!";// MySQLのパスワード

	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				Scanner scanner = new Scanner(System.in)) {

			while (true) {
				//メニュー表示
				System.out.println("1: 商品登録");
				System.out.println("2: 商品更新");
				System.out.println("3: 商品削除");
				System.out.println("4: 終了");
				System.out.print("番号を選んでください: ");
				int choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {
				case 1:
					insertProduct(connection, scanner);
					break;
				case 2:
					updateProduct(connection, scanner);
					break;
				case 3:
					deleteProduct(connection, scanner);
					break;
				case 4:
					System.out.println("終了します。");
					return;
				default:
					System.out.println("無効な選択です。");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// パート1: データの追加
	static void insertProduct(Connection connection, Scanner scanner) {
		try {
			System.out.println("--商品の登録-- ");
			System.out.println("商品名を入力してください: ");
			String name = scanner.nextLine();

			System.out.println("価格を入力してください: ");
			int price = scanner.nextInt();
			System.out.println("在庫数を入力してください: ");
			int stock = scanner.nextInt();
			System.out.println("カテゴリIDを入力してください: ");
			int categoryId = scanner.nextInt();

			String sql = "INSERT INTO products (name, price, stock, category_id) VALUES (?, ?, ?, ?)";
			try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
				//値を設定
				pstmt.setString(1, name);
				pstmt.setInt(2, price);
				pstmt.setInt(3, stock);
				pstmt.setInt(4, categoryId);

				int product = pstmt.executeUpdate();
				//データ追加の表示
				System.out.println("登録成功件数：" + product + " 件");
				System.out.println("登録内容：");
				System.out.println("商品名：" + name + "， 価格：" + price + "， 在庫数：" + stock + "， カテゴリーID：" + categoryId);
			}
			//エラー処理
		} catch (Exception e) {
			System.out.println("商品追加中にエラーが発生しました。");
			e.printStackTrace();
		}
	}

	// パート2: データ更新
	static void updateProduct(Connection connection, Scanner scanner) {
		try {
			System.out.println("--商品の価格と在庫を更新-- ");
			System.out.println("商品IDを入力してください: ");
			int id = scanner.nextInt();
			System.out.println("価格を入力してください: ");
			int price = scanner.nextInt();
			System.out.println("在庫数を入力してください: ");
			int stock = scanner.nextInt();

			String sql = "UPDATE products SET price = ?, stock = ? WHERE id = ?";
			try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
				//値を設定
				pstmt.setInt(1, price);
				pstmt.setInt(2, stock);
				pstmt.setInt(3, id);

				int product = pstmt.executeUpdate();
				if (product > 0) {
					//データ更新の表示（成功）
					System.out.println("更新成功件数：" + product + "件");
					System.out.println("更新内容：");
					System.out.println("商品ID：" + id + "， 価格：" + price + "， 在庫数：" + stock);

				} else {
					//データ更新の表示（失敗）
					System.out.println("更新成功件数：" + product + "件");
					System.out.println("更新失敗");
				}
			}
			//エラー処理
		} catch (Exception e) {
			System.out.println("商品更新中にエラーが発生しました。");
			e.printStackTrace();
		}
	}

	// パート3: データ削除
	static void deleteProduct(Connection connection, Scanner scanner) {
		try {
			System.out.println("--商品の削除-- ");
			System.out.println("商品IDを入力してください: ");
			int id = scanner.nextInt();

			String sql = "DELETE FROM products WHERE id = ?";
			try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
				//値を設定
				pstmt.setInt(1, id);

				int product = pstmt.executeUpdate();
				//データの削除の表示
				System.out.println("削除成功件数：" + product + "件");
				System.out.println("商品ID " + id + " を削除しました。");
			}
			//エラー処理
		} catch (Exception e) {
			System.out.println("商品削除中にエラーが発生しました。");
			e.printStackTrace();
		}
	}
}
