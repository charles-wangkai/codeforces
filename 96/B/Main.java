import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static long solve(int n) {
		for (int i = 1;; i++) {
			String str = String.format("%s%s", repeat('7', i), repeat('4', i));

			if (Long.parseLong(str) >= n) {
				return search(n, str.toCharArray(), 0);
			}
		}
	}

	static String repeat(char ch, int count) {
		return IntStream.range(0, count).mapToObj(i -> ch)
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
	}

	static long search(int n, char[] digits, int index) {
		if (index == digits.length) {
			long number = Long.parseLong(new String(digits));

			return (number >= n) ? number : Long.MAX_VALUE;
		}

		long result = Long.MAX_VALUE;
		for (int i = index; i < digits.length; i++) {
			swap(digits, i, index);

			result = Math.min(result, search(n, digits, index + 1));

			swap(digits, i, index);
		}

		return result;
	}

	static void swap(char[] digits, int index1, int index2) {
		char temp = digits[index1];
		digits[index1] = digits[index2];
		digits[index2] = temp;
	}
}
