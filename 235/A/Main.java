import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static long solve(int n) {
		if (n <= 2) {
			return n;
		}

		if (n % 2 == 0) {
			long result = (n - 1L) * (n - 2) * (n - 3);
			for (int i = n - 3; i >= 1; i -= 2) {
				if (gcd(n, i) == 1) {
					result = Math.max(result, n * (n - 1L) * i);

					break;
				}
			}

			return result;
		} else {
			return n * (n - 1L) * (n - 2);
		}
	}

	static int gcd(int a, int b) {
		return (b == 0) ? a : gcd(b, a % b);
	}
}
