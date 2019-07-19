import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static int solve(int n) {
		if (isPrime(n)) {
			return 1;
		}

		if (n % 2 == 0) {
			for (int i = 3; i * 2 <= n; i += 2) {
				if (isPrime(i) && isPrime(n - i)) {
					return 2;
				}
			}
		}

		return Math.min(solve(n - 2), solve(n - 3)) + 1;
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
