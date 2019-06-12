import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		System.out.print(solve(N));

		sc.close();
	}

	static String solve(int N) {
		boolean[] primes = new boolean[N + 1];
		Arrays.fill(primes, true);

		for (int i = 2; i < primes.length; i++) {
			if (primes[i]) {
				for (int j = i * 2; j < primes.length; j += i) {
					primes[j] = false;
				}
			}
		}

		List<String> pairs = new ArrayList<>();
		for (int i = 3; i + 2 < primes.length; i += 2) {
			if (primes[i] && primes[i + 2]) {
				pairs.add(String.format("2 %d", i));
			}
		}

		return String.format("%d\n%s", pairs.size(), String.join("\n", pairs));
	}
}
