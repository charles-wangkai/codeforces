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

		result.append((n * n + 1) / 2).append("\n");

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				result.append(((r + c) % 2 == 0) ? 'C' : '.');
			}
			result.append("\n");
		}

		return result.toString();
	}
}
