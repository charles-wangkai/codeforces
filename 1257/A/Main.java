import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			int x = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();

			System.out.println(solve(n, x, a, b));
		}

		sc.close();
	}

	static int solve(int n, int x, int a, int b) {
		return Math.min(n - 1, Math.abs(a - b) + x);
	}
}
