import java.util.Scanner;

public class Main {
	static final int PRICE1 = 1_234_567;
	static final int PRICE2 = 123_456;
	static final int PRICE3 = 1_234;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int n) {
		for (int i = 0; i * PRICE1 <= n; i++) {
			for (int j = 0; i * PRICE1 + j * PRICE2 <= n; j++) {
				if ((n - i * PRICE1 - j * PRICE2) % PRICE3 == 0) {
					return true;
				}
			}
		}

		return false;
	}
}
