package product;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductsManager manager = new ProductsManager();

        manager.addProduct(new Product(1, "冷蔵庫", 50000, 10));
        manager.addProduct(new DiscountedProduct(2, "ソファ", 30000, 5, 0.3));
        manager.addProduct(new Product(3, "米", 2000, 3));
        manager.addProduct(new Product(4, "小説", 1500, 4));
        manager.addProduct(new Product(5, "Tシャツ", 1500, 5));

        System.out.println("--商品名「ソファ」の情報と割引率30％の情報を表示する--");
        List<Product> result1 = manager.search("ソファ");
        for (Product p : result1) {
            System.out.println(p);
        }

        System.out.println("\n--商品名「Tシャツ」を検索して表示する--");
        List<Product> result2 = manager.search("Tシャツ");
        for (Product p : result2) {
            System.out.println(p);
        }
    }
}
