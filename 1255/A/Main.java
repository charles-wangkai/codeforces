import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			System.out.println(solve(a, b));
		}

		sc.close();
	}

	static int solve(int a, int b) {
		int result = 0;
		int diff = Math.abs(a - b);
		for (int unit : new int[] { 5, 2, 1 }) {
			result += diff / unit;
			diff %= unit;
		}

		return result;
	}
}
