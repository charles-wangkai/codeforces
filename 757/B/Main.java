import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] s = new int[n];
		for (int i = 0; i < s.length; i++) {
			s[i] = sc.nextInt();
		}
		System.out.println(solve(s));

		sc.close();
	}

	static int solve(int[] s) {
		Map<Integer, Integer> valueToCount = new HashMap<>();
		for (int value : s) {
			valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
		}

		int result = 1;
		int max = Arrays.stream(s).max().getAsInt();
		boolean[] primes = new boolean[max + 1];
		Arrays.fill(primes, true);
		for (int i = 2; i < primes.length; i++) {
			int size = 0;
			if (primes[i]) {
				for (int j = i; j < primes.length; j += i) {
					primes[j] = false;
					size += valueToCount.getOrDefault(j, 0);
				}
			}

			result = Math.max(result, size);
		}

		return result;
	}
}
