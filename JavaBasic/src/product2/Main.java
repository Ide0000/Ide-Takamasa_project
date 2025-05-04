package product2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ProductManager manager = new ProductManager();
		//メニューから操作を繰り返し選択
		while (true) {

			System.out.println("\n-- メニュー --");
			System.out.println("1: 商品追加");
			System.out.println("2: 商品情報取得");
			System.out.println("3: 商品検索");
			System.out.println("4: 商品全てを表示");
			System.out.println("5: 商品削除");
			System.out.println("0: 終了");
			System.out.println("メニューから操作を選択してください。 ");
			int choice = scanner.nextInt();

			scanner.nextLine();
			//0を選んだら繰り返しは終了
			if (choice == 0) {
				System.out.println("終了します");
				break;
			}

			switch (choice) {
			//商品追加
			case 1:
				try {
					System.out.print("商品IDを入力してください: ");
					int id = scanner.nextInt();
					System.out.println("入力された商品ID：" + id);
					scanner.nextLine();
					System.out.print("商品名を入力してください: ");
					String name = scanner.nextLine();
					System.out.println("入力された商品名：" + name);
					//空文字チェック
					if (name.trim().isEmpty()) {
						System.out.println("無効な入力です。入力された商品名：" + name);
						throw new Exception("無効な入力です。商品名を正しく入力してください。");
					}

					System.out.print("価格を入力してください: ");
					int price = scanner.nextInt();
					System.out.println("入力された価格：" + price);
					//価格は0以上に設定すること
					if (price < 0) {
						System.out.println("無効な入力です。入力された価格：" + price);
						throw new Exception("無効な入力です。価格を正しく入力してください。");
					}

					System.out.println("在庫数を入力して下さい:");
					int stock = scanner.nextInt();
					System.out.println("入力された在庫：" + stock);
					//在庫数は0以上に設定すること
					if (stock < 0) {
						System.out.println("無効な入力です。入力された在庫数：" + stock);
						throw new Exception("無効な入力です。在庫を正しく入力してください。");
					}
					//商品のインスタンスを生成してリストに追加
					Product p = new Product(id, name, price, stock);
					manager.addProduct(p);
					System.out
							.println("Product: id= " + id + ", name= " + name + ", price= " + price + ",stock= " + stock
									+ "を登録しました。");
				} catch (Exception e) {
					//入力に問題があれば例外の表示
					e.printStackTrace();
				}
				break;
			//商品情報取得
			case 2:

				System.out.print("商品情報を取得する商品名を入力してください: ");
				String getName = scanner.nextLine();
				Product found = manager.getProduct(getName);
				if (found != null) {
					System.out.println(found);//見つかった表示
				} else {
					System.out.println("商品が見つかりませんでした。");
				}

				break;
			//商品検索
			case 3:
				System.out.print("検索する商品名を入力してください: ");
				String getName1 = scanner.nextLine();
				ArrayList<Product> results = manager.searchProduct(getName1);
				if (results.isEmpty()) {
					System.out.println("一致する商品がありません。");
				} else {
					for (Product product : results) {
						System.out.println(product);
					}
				}
				break;
			//商品全てを表示
			case 4:
				manager.displayAllProducts();
				break;
			//商品削除
			case 5:
				System.out.print("削除する商品のIDを入力してください: ");
				int deleteId = scanner.nextInt();
				if (manager.deleteProduct(deleteId)) {
					System.out.println("商品IDが" + deleteId + "の商品を削除しました。");
				} else {
					System.out.println("削除対象の商品が見つかりません。");
				}
				break;
			//メニューで0〜5以外を入力したとき
			default:
				System.out.println("無効な選択です。");
				break;
			}
		}
	}
}
