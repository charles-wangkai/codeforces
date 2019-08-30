import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			int d = sc.nextInt();

			System.out.println(solve(n, x, y, d));
		}

		sc.close();
	}

	static int solve(int n, int x, int y, int d) {
		int minPressNum = Integer.MAX_VALUE;

		if (Math.abs(x - y) % d == 0) {
			minPressNum = Math.min(minPressNum, Math.abs(x - y) / d);
		}
		if ((y - 1) % d == 0) {
			minPressNum = Math.min(minPressNum, divideToCeil(x - 1, d) + (y - 1) / d);
		}
		if ((n - y) % d == 0) {
			minPressNum = Math.min(minPressNum, divideToCeil(n - x, d) + (n - y) / d);
		}

		return (minPressNum == Integer.MAX_VALUE) ? -1 : minPressNum;
	}

	static int divideToCeil(int x, int y) {
		return x / y + (x % y == 0 ? 0 : 1);
	}
}
