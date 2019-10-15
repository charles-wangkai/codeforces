import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			int k = sc.nextInt();

			System.out.println(solve(a, b, c, d, k));
		}

		sc.close();
	}

	static String solve(int a, int b, int c, int d, int k) {
		int x = divideToCeil(a, c);
		int y = divideToCeil(b, d);

		return (x + y <= k) ? String.format("%d %d", x, y) : "-1";
	}

	static int divideToCeil(int p, int q) {
		return p / q + (p % q == 0 ? 0 : 1);
	}
}
