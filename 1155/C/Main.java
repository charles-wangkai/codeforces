import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		long[] x = readArray(sc, n);
		long[] p = readArray(sc, m);
		System.out.print(solve(x, p));

		sc.close();
	}

	static long[] readArray(Scanner sc, int size) {
		long[] result = new long[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextLong();
		}

		return result;
	}

	static String solve(long[] x, long[] p) {
		long g = x[1] - x[0];
		for (int i = 1; i < x.length - 1; i++) {
			g = gcd(g, x[i + 1] - x[i]);
		}

		for (int i = 0; i < p.length; i++) {
			if (g % p[i] == 0) {
				return String.format("YES\n%d %d", x[0], i + 1);
			}
		}

		return "NO";
	}

	static long gcd(long a, long b) {
		return (b == 0) ? a : gcd(b, a % b);
	}
}
