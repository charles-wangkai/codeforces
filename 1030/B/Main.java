import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int d = sc.nextInt();
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			System.out.println(solve(n, d, x, y) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(int n, int d, int x, int y) {
		return x + y >= d && x + y <= 2 * n - d && Math.abs(x - y) <= d;
	}
}
