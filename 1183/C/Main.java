import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();

			System.out.println(solve(k, n, a, b));
		}

		sc.close();
	}

	static int solve(int k, int n, int a, int b) {
		if ((long) b * n >= k) {
			return -1;
		}

		return Math.min(n, (k - b * n) / (a - b) - (((k - b * n) % (a - b) == 0) ? 1 : 0));
	}
}
