import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int t = sc.nextInt();
		int k = sc.nextInt();
		int d = sc.nextInt();
		System.out.println(solve(n, t, k, d) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int n, int t, int k, int d) {
		int timeWithOneOven = divideToCeil(n, k) * t;

		int timeWithTwoOven = -1;
		int lower = 0;
		int upper = timeWithOneOven;
		while (lower <= upper) {
			int middle = (lower + upper) / 2;

			if (check(n, t, k, d, middle)) {
				timeWithTwoOven = middle;

				upper = middle - 1;
			} else {
				lower = middle + 1;
			}
		}

		return timeWithTwoOven < timeWithOneOven;
	}

	static int divideToCeil(int x, int y) {
		return x / y + (x % y == 0 ? 0 : 1);
	}

	static boolean check(int n, int t, int k, int d, int time) {
		return time / t * k + Math.max(0, time - d) / t * k >= n;
	}
}
