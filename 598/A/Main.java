import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();

			System.out.println(solve(n));
		}

		sc.close();
	}

	static long solve(int n) {
		long result = (long) n * (n + 1) / 2;
		for (int power = 1; power <= n; power *= 2) {
			result -= 2 * power;
		}
		return result;
	}
}
