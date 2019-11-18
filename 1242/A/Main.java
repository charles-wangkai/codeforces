import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		System.out.println(solve(n));

		sc.close();
	}

	static long solve(long n) {
		long result = n;
		for (int i = 2; (long) i * i <= n; i++) {
			if (n % i == 0) {
				result = gcd(result, gcd(i, n / i));
			}
		}

		return result;
	}

	static long gcd(long a, long b) {
		return (b == 0) ? a : gcd(b, a % b);
	}
}
