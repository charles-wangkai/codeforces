import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		long k = sc.nextLong();
		System.out.println(solve(n, m, k));

		sc.close();
	}

	static long solve(int n, int m, long k) {
		long result = -1;
		long lower = 1;
		long upper = (long) n * m;
		while (lower <= upper) {
			long middle = (lower + upper) / 2;

			boolean appeared = false;
			long nonGreaterCount = 0;
			for (int i = 1; i <= n; i++) {
				if (middle % i == 0 && middle / i <= m) {
					appeared = true;
				}

				nonGreaterCount += Math.min(m, middle / i);
			}

			if (nonGreaterCount >= k) {
				if (appeared) {
					result = middle;
				}

				upper = middle - 1;
			} else {
				lower = middle + 1;
			}
		}

		return result;
	}
}
