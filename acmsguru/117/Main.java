import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		int[] sequence = new int[N];
		for (int i = 0; i < sequence.length; i++) {
			sequence[i] = sc.nextInt();
		}
		System.out.println(solve(sequence, M, K));

		sc.close();
	}

	static int solve(int[] sequence, int M, int K) {
		Map<Integer, Integer> primeToExponent = buildPrimeToExponent(K);

		return (int) Arrays.stream(sequence).filter(x -> isValid(primeToExponent, x, M)).count();
	}

	static boolean isValid(Map<Integer, Integer> primeToExponent, int x, int M) {
		for (int prime : primeToExponent.keySet()) {
			int exponent = 0;
			while (x % prime == 0) {
				exponent++;
				x /= prime;
			}

			if (exponent * M < primeToExponent.get(prime)) {
				return false;
			}
		}

		return true;
	}

	static Map<Integer, Integer> buildPrimeToExponent(int x) {
		Map<Integer, Integer> primeToExponent = new HashMap<>();
		for (int i = 2; i * i <= x; i++) {
			if (isPrime(i)) {
				int exponent = 0;
				while (x % i == 0) {
					exponent++;
					x /= i;
				}

				if (exponent != 0) {
					primeToExponent.put(i, exponent);
				}
			}
		}
		if (x != 1) {
			primeToExponent.put(x, 1);
		}

		return primeToExponent;
	}

	static boolean isPrime(int x) {
		for (int i = 2; i * i <= x; i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}
}
