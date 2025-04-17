package method.q10;

import java.util.Arrays;

public class EvenNumber {
	public static int getEvenNumbers(int[] numbers) {
		int count = 0;
		for (int num : numbers) {
			if (num % 2 == 0) {
				count++; // 偶数をカウント
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] numbers = { 3, 2, 5, 6, 7, 25, 10, 51, 88, 98 }; // 指定された配列

		// 配列の表示
		System.out.println(Arrays.toString(numbers) + "には、偶数が" + getEvenNumbers(numbers) + "個あります。");
	}
}
