package product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductsManager implements Searchable {
	private List<Product> products = new ArrayList<>();

	public void addProduct(Product product) {
		products.add(product);
	}

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

	public void displayAllProducts() {
		for (Product p : products) {
			System.out.println(p);
		}
	}

	// インターフェースから実装
	@Override
	public List<Product> search(String keyword) {
		List<Product> result = new ArrayList<>();
		for (Product p : products) {
			if (p.getName().equals(keyword)) {
				result.add(p);
			}
		}
		return result;
	}
}
