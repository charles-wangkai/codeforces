import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.print(solve(n));

		sc.close();
	}

	static String solve(int n) {
		StringBuilder result = new StringBuilder();

		result.append(n).append('\n');
		for (int i = 0; i < n; i++) {
			if (i != 0) {
				result.append(' ');
			}

			result.append('1');
		}
		result.append('\n');

		return result.toString();
	}
}
