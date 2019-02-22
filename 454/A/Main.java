import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.print(solve(n));

		sc.close();
	}

	static String solve(int n) {
		char[][] matrix = new char[n][n];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				matrix[r][c] = (Math.abs(r - n / 2) + Math.abs(c - n / 2) <= n / 2) ? 'D' : '*';
			}
		}

		return String.join("\n", Arrays.stream(matrix).map(String::new).toArray(String[]::new));
	}
}
