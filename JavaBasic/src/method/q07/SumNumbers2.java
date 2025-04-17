package method.q07;

public class SumNumbers2 {
	public static int calculateSum(int a, double b) {
		return (int) (a + b); // 結果を整数型にキャスト
	}

	public static void main(String[] args) {
		int num1 = 5;
		double num2 = 3.3;
		int result = calculateSum(num1, num2);

		System.out.println("第一引数（整数）：" + num1);
		System.out.println("第二引数（実数）：" + num2);
		System.out.println("加算結果：" + result);
	}
}
