import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		System.out.println(solve(n, a, b, c, d));

		sc.close();
	}

	static long solve(int n, int a, int b, int c, int d) {
		return IntStream.rangeClosed(1, n).filter(
				x -> isBetween(1, n, x + b - c) && isBetween(1, n, x + a - d) && isBetween(1, n, x + a + b - c - d))
				.count() * n;
	}

	static boolean isBetween(int minLimit, int maxLimit, int value) {
		return value >= minLimit && value <= maxLimit;
	}
}
