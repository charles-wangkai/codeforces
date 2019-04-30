import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] w = new int[n];
		int[] h = new int[n];
		for (int i = 0; i < n; i++) {
			w[i] = sc.nextInt();
			h[i] = sc.nextInt();
		}
		System.out.println(solve(w, h) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int[] w, int[] h) {
		int prev = Integer.MAX_VALUE;
		for (int i = 0; i < w.length; i++) {
			int min = Math.min(w[i], h[i]);
			int max = Math.max(w[i], h[i]);

			if (min > prev) {
				return false;
			}

			if (max <= prev) {
				prev = max;
			} else {
				prev = min;
			}
		}
		return true;
	}
}
