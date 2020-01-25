import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; ++tc) {
			int n = sc.nextInt();

			System.out.println(solve(n));
		}

		sc.close();
	}

	static String solve(int n) {
		for (int a = 2; a * a * a < n; ++a) {
			if (n % a == 0) {
				for (int b = a + 1; a * b * b < n; ++b) {
					if (n / a % b == 0) {
						return String.format("YES\n%d %d %d", a, b, n / a / b);
					}
				}
			}
		}

		return "NO";
	}
}
