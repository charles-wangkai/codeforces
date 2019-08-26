import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int n = sc.nextInt();

			System.out.println(solve(a, b, n));
		}

		sc.close();
	}

	static int solve(int a, int b, int n) {
		int remainder = n % 3;
		if (remainder == 0) {
			return a;
		} else if (remainder == 1) {
			return b;
		} else {
			return a ^ b;
		}
	}
}
