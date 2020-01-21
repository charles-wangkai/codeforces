import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long X = sc.nextLong();
		System.out.println(solve(X));

		sc.close();
	}

	static String solve(long X) {
		int a = -1;
		long b = -1;
		for (int i = 1; (long) i * i <= X; ++i) {
			if (X % i == 0 && gcd(i, X / i) == 1) {
				a = i;
				b = X / i;
			}
		}

		return String.format("%d %d", a, b);
	}

	static long gcd(long x, long y) {
		return (y == 0) ? x : gcd(y, x % y);
	}
}
