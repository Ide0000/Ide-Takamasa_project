package product2;

import java.util.ArrayList;

//商品情報を管理するクラス
public class ProductManager {
	//商品のリスト
	private ArrayList<Product> productList = new ArrayList<>();

	//商品をリストに追加する
	public void addProduct(Product product) {
		productList.add(product);
	}

	//商品名が一致する商品を取得する
	public Product getProduct(String getName) {
		for (Product p : productList) {
			if (p.getName().equals(getName)) {
				return p;
			}
		}
		return null;
	}

	//商品を検索する
	public ArrayList<Product> searchProduct(String keyword) {
		ArrayList<Product> result = new ArrayList<>();
		for (Product p : productList) {
			if (p.getName().contains(keyword)) {
				result.add(p);
			}
		}
		return result;
	}

	//登録されている全ての商品の情報を表示する
	public void displayAllProducts() {
		for (Product p : productList) {
			System.out.println(p);
		}
	}

	//idでリストから商品を削除する
	public boolean deleteProduct(int id) {
		return productList.removeIf(p -> p.getId() == id);
	}
}
