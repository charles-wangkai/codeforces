import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; ++tc) {
			int n = sc.nextInt();
			int d = sc.nextInt();

			System.out.println(solve(n, d) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(int n, int d) {
		for (int x = 0; (x + 1) * (x + 1) <= d; ++x) {
			if (x + divideToCeil(d, x + 1) <= n) {
				return true;
			}
		}

		return false;
	}

	static int divideToCeil(int x, int y) {
		return x / y + (x % y == 0 ? 0 : 1);
	}
}
