import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		long m = sc.nextLong();
		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			int sx = sc.nextInt();
			long sy = sc.nextLong();
			int ex = sc.nextInt();
			long ey = sc.nextLong();

			System.out.println(solve(n, m, sx, sy, ex, ey) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(long n, long m, int sx, long sy, int ex, long ey) {
		long g = gcd(n, m);

		long cycle1 = n / g;
		long cycle2 = m / g;

		return computePartIndex(cycle1, cycle2, sx, sy) == computePartIndex(cycle1, cycle2, ex, ey);
	}

	static long gcd(long a, long b) {
		return (b == 0) ? a : gcd(b, a % b);
	}

	static long computePartIndex(long cycle1, long cycle2, int x, long y) {
		return (y - 1) / ((x == 1) ? cycle1 : cycle2);
	}
}
