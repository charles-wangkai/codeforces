import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[][] a = new int[n][n];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				a[r][c] = sc.nextInt();
			}
		}
		System.out.println(solve(a) ? "Yes" : "No");

		sc.close();
	}

	static boolean solve(int[][] a) {
		int n = a.length;

		return IntStream.range(0, n)
				.allMatch(r -> IntStream.range(0, n).allMatch(c -> a[r][c] == 1 || canFindSum(a, r, c)));
	}

	static boolean canFindSum(int[][] a, int r, int c) {
		int n = a.length;

		return IntStream.range(0, n).anyMatch(i -> IntStream.range(0, n).anyMatch(j -> a[i][c] + a[r][j] == a[r][c]));
	}
}
