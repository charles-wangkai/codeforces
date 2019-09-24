import java.util.Scanner;

public class Main {
	static final double EPSILON = 1e-6;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = readArray(sc, n);
		int[] b = readArray(sc, n);
		System.out.println(solve(a, b, m));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}

		return result;
	}

	static double solve(int[] a, int[] b, int m) {
		double result = -1;
		double lower = 0;
		double upper = 1_000_000_001;
		while (Math.abs(upper - lower) > EPSILON) {
			double middle = (lower + upper) / 2;

			if (check(a, b, m, middle)) {
				result = middle;

				upper = middle;
			} else {
				lower = middle;
			}
		}

		return result;
	}

	static boolean check(int[] a, int[] b, int m, double fuel) {
		int n = a.length;

		for (int i = 0; i < n; i++) {
			double needed = (m + fuel) / a[i];
			if (fuel < needed) {
				return false;
			}
			fuel -= needed;

			needed = (m + fuel) / b[(i + 1) % n];
			if (fuel < needed) {
				return false;
			}
			fuel -= needed;
		}

		return true;
	}
}
