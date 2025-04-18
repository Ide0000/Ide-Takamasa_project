package product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductsManager {
	private List<Product> products = new ArrayList<>();

	// 商品追加
	public void addProduct(Product product) {
		products.add(product);
	}

	// 商品削除
	public void removeProduct(int id) {
		Iterator<Product> iterator = products.iterator();
		while (iterator.hasNext()) {
			Product p = iterator.next();
			if (p.getId() == id) {
				iterator.remove();
				break;
			}
		}
	}

	// 商品名で検索
	public Product getProductByName(String name) {
		for (Product p : products) {
			if (p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}

	// 商品すべて表示
	public void displayAllProducts() {
		for (Product p : products) {
			System.out.println(p);
		}
	}
}
