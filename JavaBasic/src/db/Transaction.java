package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Transaction {
	public static void main(String[] args) {
		//データベース接続情報
		final String URL = "jdbc:mysql://localhost:3306/product_management";
		final String USER = "root";
		final String PASSWORD = "c84-tsa5TKMS!";
		// try-with-resources構文でScannerとDB接続を自動的にクローズ
		try (Scanner scanner = new Scanner(System.in);
				Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
			connection.setAutoCommit(false); // トランザクション開始
			//入力用の配列
			int[] id = new int[2];
			int[] price = new int[2];
			int[] stock = new int[2];

			int totalCount = 0;//入力された回数
			int successCount = 0;//成功した回数
			try {
				// 1回目の更新処理
				System.out.println("--商品価格と在庫を更新①--");
				System.out.println("商品IDを入力して下さい：");
				id[0] = scanner.nextInt();
				System.out.println("価格を入力して下さい：");
				price[0] = scanner.nextInt();
				System.out.println("在庫数を入力して下さい：");
				stock[0] = scanner.nextInt();

				// 2回目の更新処理
				System.out.println("\n--商品価格と在庫を更新②--");
				System.out.println("商品IDを入力して下さい：");
				id[1] = scanner.nextInt();
				System.out.println("価格を入力して下さい：");
				price[1] = scanner.nextInt();
				System.out.println("在庫数を入力して下さい：");
				stock[1] = scanner.nextInt();

				//SQL文の準備
				String sql = "UPDATE products SET price = ?, stock = ? WHERE id = ?";
				try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
					for (int i = 0; i < 2; i++) {
						//パラメータをセット
						pstmt.setInt(1, price[i]);
						pstmt.setInt(2, stock[i]);
						pstmt.setInt(3, id[i]);
						//更新件数や成功件数
						int count = pstmt.executeUpdate();
						successCount += count;
						totalCount++;
						if (count == 0) {
							throw new SQLException();
						}
					}
				}
				// コミット（全て成功した場合）
				connection.commit();
				System.out.println("\nコミット成功");
				System.out.println("更新成功件数： " + totalCount + "件");
				System.out.println("\n更新内容①：\n商品ID: " + id[0] + ", 価格: " + price[0] + ", 在庫数: " + stock[0]);
				System.out.println("\n更新内容②：\n商品ID: " + id[1] + ", 価格: " + price[1] + ", 在庫数: " + stock[1]);
			} catch (SQLException e) {
				//エラー発生時はロールバック
				connection.rollback();
				System.out.println(totalCount + "件全ての更新に失敗しました。");
				System.out.println("更新成功件数： " + successCount + "件");
				System.out.println("ロールバックしました。");
				e.printStackTrace();
			}
		} catch (SQLException e) {
			//DB接続失敗時の処理
			System.out.println("データベース接続に失敗しました。");
			e.printStackTrace();
		}
	}
}
