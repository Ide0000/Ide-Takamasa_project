package product2;

//商品情報を表すクラス
public class Product {
	//商品id,商品名,価格,在庫数
	private int id;
	private String name;
	private int price;
	private int stock;

	//商品情報の初期化
	public Product(int id, String name, int price, int stock) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	//getter（値を取得）

	public int getId() {
		return id;

	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	//setter（値の設定）

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	// toString() を使って商品情報を文字列で返す
	@Override
	public String toString() {
		return "Product: id=" + id + ",name=" + name + ",price=" + price + ",stock=" + stock;
	}
}
