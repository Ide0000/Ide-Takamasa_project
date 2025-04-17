package method.q09;

import java.util.Random;

public class Even {
	public static boolean checkEven(int num) {
		return num % 2 == 0; // 偶数の場合はtrue
	}

	public static void main(String[] args) {
		Random random = new Random(); // Randomインスタンスを作成
		int num1 = random.nextInt(100) + 1; // 1から100のランダムな整数を生成

		if (checkEven(num1)) {
			System.out.println(num1 + "は偶数です。");
		} else {
			System.out.println(num1 + "は奇数です。");
		}
	}
}
