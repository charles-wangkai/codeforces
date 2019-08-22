import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] c = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				c[i][j] = sc.nextInt();
			}
		}
		System.out.println(solve(c));

		sc.close();
	}

	static int solve(int[][] c) {
		return Arrays.stream(c).mapToInt(row -> Arrays.stream(row).min().getAsInt()).max().getAsInt();
	}
}
