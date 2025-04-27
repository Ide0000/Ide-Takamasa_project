package product;

public class DiscountedProduct extends Product {
	private double discountRate; // 割引率（0.3 → 30%）

	public DiscountedProduct(int id, String name, int price, int stock, double discountRate) {
		super(id, name, price, stock);
		this.discountRate = discountRate;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}

	public int calculateDiscountedPrice() {
		return (int) (getPrice() * (1 - discountRate));
	}

	@Override
	public String toString() {
		return "Product: id=" + getId() + ", name=" + getName() + ", price=" + getPrice() + ", stock=" + getStock()
				+ ", 割引率=" + discountRate + ", 割引後価格=" + calculateDiscountedPrice();
	}
}
