import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static String solve(int n) {
		for (int numerator = n / 2;; numerator--) {
			int denominator = n - numerator;

			if (numerator < denominator && gcd(numerator, denominator) == 1) {
				return String.format("%d %d", numerator, denominator);
			}
		}
	}

	static int gcd(int a, int b) {
		return (b == 0) ? a : gcd(b, a % b);
	}
}
