import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static String solve(int n) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				result.append("I hate");
			} else {
				result.append("I love");
			}

			if (i == n - 1) {
				result.append(" it");
			} else {
				result.append(" that ");
			}
		}
		return result.toString();
	}
}
