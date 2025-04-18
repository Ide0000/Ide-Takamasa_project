package product;

public class Main {
	public static void main(String[] args) {
		ProductsManager manager = new ProductsManager();

		// 商品を5つ追加
		manager.addProduct(new Product(1, "冷蔵庫", 50000, 10));
		manager.addProduct(new Product(2, "ソファ", 30000, 5));
		manager.addProduct(new Product(3, "米", 2000, 3));
		manager.addProduct(new Product(4, "小説", 1500, 4));
		manager.addProduct(new Product(5, "Tシャツ", 1500, 5));

		// 全商品を表示
		System.out.println("---商品を５つ追加して全てを表示する---");
		manager.displayAllProducts();

		// 商品を1つ削除（id=1）
		manager.removeProduct(1);

		// 残りを表示
		System.out.println("\n---商品を１つ削除して全てを表示する---");
		manager.displayAllProducts();

		// 商品名「米」の情報を表示
		System.out.println("\n---商品名「米」の情報を表示する---");
		Product rice = manager.getProductByName("米");
		if (rice != null) {
			System.out.println(rice);

		}
	}
}
