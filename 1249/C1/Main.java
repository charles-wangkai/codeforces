import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			int n = sc.nextInt();

			System.out.println(solve(n));
		}

		sc.close();
	}

	static int solve(int n) {
		for (int m = n;; m++) {
			if (isGood(m)) {
				return m;
			}
		}
	}

	static boolean isGood(int x) {
		while (x != 0) {
			if (x % 3 == 2) {
				return false;
			}

			x /= 3;
		}

		return true;
	}
}
