import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static final int MODULUS = 1 << 30;
	static final int LIMIT = 100;

	static int[] primes = buildPrimes();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println(solve(a, b, c));

		sc.close();
	}

	static int[] buildPrimes() {
		return IntStream.rangeClosed(2, LIMIT).filter(Main::isPrime).toArray();
	}

	static boolean isPrime(int x) {
		for (int i = 2; i * i <= x; ++i) {
			if (x % i == 0) {
				return false;
			}
		}

		return true;
	}

	static int solve(int a, int b, int c) {
		int result = 0;
		for (int i = 1; i <= a; ++i) {
			for (int j = 1; j <= b; ++j) {
				for (int k = 1; k <= c; ++k) {
					result = addMod(result, d(i * j * k));
				}
			}
		}

		return result;
	}

	static int addMod(int x, int y) {
		return (x + y) % MODULUS;
	}

	static int d(int n) {
		int result = 1;
		for (int prime : primes) {
			if (n == 1) {
				break;
			}

			int exponent = 0;
			while (n % prime == 0) {
				++exponent;
				n /= prime;
			}

			result *= exponent + 1;
		}

		return result;
	}
}
