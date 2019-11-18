import java.util.Scanner;

public class Main {
	static final int[] SMALL_LIMITS = { -1, 1, 3, 3 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			System.out.println(solve(x, y) ? "YES" : "NO");
		}

		sc.close();
	}

	static boolean solve(int x, int y) {
		return x >= SMALL_LIMITS.length || y <= SMALL_LIMITS[x];
	}
}
