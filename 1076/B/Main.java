import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		System.out.println(solve(n));

		sc.close();
	}

	static long solve(long n) {
		if (n % 2 == 0) {
			return n / 2;
		}

		for (int i = 3; (long) i * i <= n; i += 2) {
			if (n % i == 0) {
				return solve(n - i) + 1;
			}
		}

		return 1;
	}
}
