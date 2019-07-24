import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(Arrays.stream(solve(n)).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

		sc.close();
	}

	static int[] solve(int n) {
		List<Integer> primes = buildPrimes(n);

		int[] a = new int[n + 1];
		Arrays.fill(a, -1);

		int value = 1;
		for (int prime : primes) {
			for (int i = prime; i < a.length; i += prime) {
				if (a[i] == -1) {
					a[i] = value;
				}
			}

			value++;
		}

		return Arrays.copyOfRange(a, 2, a.length);
	}

	static List<Integer> buildPrimes(int n) {
		boolean[] isPrimes = new boolean[n + 1];
		Arrays.fill(isPrimes, true);

		List<Integer> primes = new ArrayList<>();
		for (int i = 2; i < isPrimes.length; i++) {
			if (isPrimes[i]) {
				primes.add(i);

				for (long j = (long) i * i; j < isPrimes.length; j += i) {
					isPrimes[(int) j] = false;
				}
			}
		}
		return primes;
	}
}
