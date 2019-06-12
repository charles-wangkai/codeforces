import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
	static final int PRIME_LIMIT = 1000;
	static final int DIVISOR_LIMIT = 1000000;

	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] numbers = new int[n];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(solve(numbers));
	}

	static int solve(int[] numbers) {
		int[] primes = buildPrimes();

		int[] divisorCounts = new int[DIVISOR_LIMIT + 1];

		for (int number : numbers) {
			for (int divisor : buildDivisor(primes, number)) {
				divisorCounts[divisor]++;
			}
		}

		for (int i = divisorCounts.length - 1;; i--) {
			if (divisorCounts[i] >= 2) {
				return i;
			}
		}
	}

	static int[] buildPrimes() {
		return IntStream.rangeClosed(2, PRIME_LIMIT).filter(Main::isPrime).toArray();
	}

	static List<Integer> buildDivisor(int[] primes, int n) {
		List<PrimeAndExponent> pes = new ArrayList<>();
		for (int prime : primes) {
			int exponent = 0;
			while (n % prime == 0) {
				exponent++;
				n /= prime;
			}

			if (exponent != 0) {
				pes.add(new PrimeAndExponent(prime, exponent));
			}
		}

		if (n != 1) {
			pes.add(new PrimeAndExponent(n, 1));
		}

		List<Integer> divisors = new ArrayList<>();
		search(divisors, pes, 1, 0);
		return divisors;
	}

	static void search(List<Integer> divisors, List<PrimeAndExponent> pes, int divisor, int index) {
		if (index == pes.size()) {
			divisors.add(divisor);

			return;
		}

		int power = 1;
		for (int i = 0; i <= pes.get(index).exponent; i++) {
			search(divisors, pes, divisor * power, index + 1);

			power *= pes.get(index).prime;
		}
	}

	static boolean isPrime(int n) {
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}

class PrimeAndExponent {
	int prime;
	int exponent;

	PrimeAndExponent(int prime, int exponent) {
		this.prime = prime;
		this.exponent = exponent;
	}
}