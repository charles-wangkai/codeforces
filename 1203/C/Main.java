import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long[] a = new long[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextLong();
		}
		System.out.println(solve(a));

		sc.close();
	}

	static int solve(long[] a) {
		long g = a[0];
		for (int i = 1; i < a.length; i++) {
			g = gcd(g, a[i]);
		}

		return computeDivisorNum(g);
	}

	static long gcd(long x, long y) {
		return (y == 0) ? x : gcd(y, x % y);
	}

	static int computeDivisorNum(long x) {
		int result = 1;
		for (int i = 2; (long) i * i <= x; i++) {
			int count = 0;
			while (x % i == 0) {
				count++;
				x /= i;
			}

			result *= count + 1;
		}

		if (x != 1) {
			result *= 2;
		}

		return result;
	}
}
