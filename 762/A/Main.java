import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		int k = sc.nextInt();
		System.out.println(solve(n, k));

		sc.close();
	}

	static long solve(long n, int k) {
		List<Long> divisors = new ArrayList<>();
		for (int i = 1; (long) i * i <= n; i++) {
			if (n % i == 0) {
				divisors.add((long) i);

				if (n / i != i) {
					divisors.add(n / i);
				}
			}
		}

		Collections.sort(divisors);

		return (k <= divisors.size()) ? divisors.get(k - 1) : -1;
	}
}
