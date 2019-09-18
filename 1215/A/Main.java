import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a1 = sc.nextInt();
		int a2 = sc.nextInt();
		int k1 = sc.nextInt();
		int k2 = sc.nextInt();
		int n = sc.nextInt();
		System.out.print(solve(a1, a2, k1, k2, n));

		sc.close();
	}

	static String solve(int a1, int a2, int k1, int k2, int n) {
		return String.format("%d %d", computeMinThrown(a1, a2, k1, k2, n), computeMaxThrown(a1, a2, k1, k2, n));

	}

	static int computeMinThrown(int a1, int a2, int k1, int k2, int n) {
		return Math.max(0, n - (a1 * (k1 - 1) + a2 * (k2 - 1)));
	}

	static int computeMaxThrown(int a1, int a2, int k1, int k2, int n) {
		if (k1 > k2) {
			return computeMaxThrown(a2, a1, k2, k1, n);
		}

		return Math.min(a1, n / k1) + Math.max(0, n - k1 * a1) / k2;
	}
}
