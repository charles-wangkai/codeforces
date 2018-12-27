import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final int PRIME_LIMIT = 1_000_000;

	static boolean[] primes = buildPrimes();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			long x = sc.nextLong();

			System.out.println(solve(x) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean[] buildPrimes() {
		boolean[] primes = new boolean[PRIME_LIMIT + 1];
		Arrays.fill(primes, 2, primes.length, true);

		for (int i = 2; i < primes.length; i++) {
			if (primes[i]) {
				for (int j = 2 * i; j < primes.length; j += i) {
					primes[j] = false;
				}
			}
		}

		return primes;
	}

	static boolean solve(long x) {
		int root = (int) Math.round(Math.sqrt(x));
		return (long) root * root == x && primes[root];
	}
}
