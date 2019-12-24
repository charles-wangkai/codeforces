import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static final int MODULUS = 1_000_000_007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		long n = sc.nextLong();
		System.out.println(solve(x, n));

		sc.close();
	}

	static int solve(int x, long n) {
		List<Integer> primeFactors = buildPrimeFactors(x);

		int result = 1;
		for (int primeFactor : primeFactors) {
			result = multiplyMod(result, powMod(primeFactor, computeFactorNum(primeFactor, n)));
		}

		return result;
	}

	static int multiplyMod(int x, int y) {
		return (int) ((long) x * y % MODULUS);
	}

	static int powMod(int base, long exponent) {
		return BigInteger.valueOf(base).modPow(BigInteger.valueOf(exponent), BigInteger.valueOf(MODULUS)).intValue();
	}

	static long computeFactorNum(int primeFactor, long n) {
		return (n == 0) ? 0 : (n / primeFactor + computeFactorNum(primeFactor, n / primeFactor));
	}

	static List<Integer> buildPrimeFactors(int x) {
		List<Integer> primeFactors = new ArrayList<>();
		for (int i = 2; i * i <= x; ++i) {
			if (x % i == 0) {
				primeFactors.add(i);

				while (x % i == 0) {
					x /= i;
				}
			}
		}
		if (x != 1) {
			primeFactors.add(x);
		}

		return primeFactors;
	}
}
