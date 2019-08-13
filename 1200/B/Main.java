import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int[] h = new int[n];
			for (int i = 0; i < h.length; i++) {
				h[i] = sc.nextInt();
			}

			System.out.println(solve(h, m, k) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(int[] h, int m, int k) {
		for (int i = 0; i < h.length - 1; i++) {
			int needed = Math.max(0, h[i + 1] - k);

			if (h[i] + m < needed) {
				return false;
			}

			m += h[i] - needed;
		}

		return true;
	}
}
