import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.print(solve(n));

		sc.close();
	}

	static String solve(int n) {
		Map<Integer, Integer> primeToPosition = buildPrimeToPosition(n);

		int[] superPrimes = primeToPosition.keySet().stream()
				.filter(prime -> primeToPosition.containsKey(primeToPosition.get(prime))).sorted().mapToInt(x -> x)
				.toArray();

		int[] minNums = new int[n + 1];
		for (int i = 1; i < minNums.length; i++) {
			for (int superPrime : superPrimes) {
				if (superPrime <= i && (i == superPrime || minNums[i - superPrime] != 0)) {
					minNums[i] = Math.min((minNums[i] == 0) ? Integer.MAX_VALUE : minNums[i],
							minNums[i - superPrime] + 1);
				}
			}
		}

		List<Integer> numbers = new ArrayList<>();
		int remain = n;
		while (minNums[remain] != 0) {
			for (int superPrime : superPrimes) {
				if (superPrime <= remain
						&& (remain == superPrime || (minNums[remain] - 1 == minNums[remain - superPrime]
								&& minNums[remain - superPrime] != 0))) {
					numbers.add(superPrime);
					remain -= superPrime;

					break;
				}
			}
		}

		Collections.sort(numbers, Collections.reverseOrder());

		return String.format("%d%s%s", numbers.size(), System.lineSeparator(),
				numbers.stream().map(String::valueOf).collect(Collectors.joining(" ")));
	}

	static Map<Integer, Integer> buildPrimeToPosition(int limit) {
		Map<Integer, Integer> primeToPosition = new HashMap<>();

		boolean[] primes = new boolean[limit + 1];
		Arrays.fill(primes, true);
		int position = 1;
		for (int i = 2; i < primes.length; i++) {
			if (primes[i]) {
				primeToPosition.put(i, position);
				position++;

				for (int j = i * i; j < primes.length; j += i) {
					primes[j] = false;
				}
			}
		}

		return primeToPosition;
	}
}
