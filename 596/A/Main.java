import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		System.out.println(solve(x, y));

		sc.close();
	}

	static int solve(int[] x, int[] y) {
		int n = x.length;

		if (n == 1 || (n == 2 && (x[0] == x[1] || y[0] == y[1]))) {
			return -1;
		}

		for (int i = 0;; i++) {
			for (int j = i + 1; j < n; j++) {
				if (x[i] != x[j] && y[i] != y[j]) {
					return Math.abs(x[i] - x[j]) * Math.abs(y[i] - y[j]);
				}
			}
		}
	}
}
