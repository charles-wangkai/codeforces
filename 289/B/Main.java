import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int d = sc.nextInt();
		int[][] a = new int[n][m];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				a[r][c] = sc.nextInt();
			}
		}
		System.out.println(solve(a, d));

		sc.close();
	}

	static int solve(int[][] a, int d) {
		int n = a.length;
		int m = a[0].length;

		if (!IntStream.range(0, n).allMatch(r -> IntStream.range(0, m).allMatch(c -> a[r][c] % d == a[0][0] % d))) {
			return -1;
		}

		int minValue = Integer.MAX_VALUE;
		int maxValue = Integer.MIN_VALUE;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				minValue = Math.min(minValue, a[r][c]);
				maxValue = Math.max(maxValue, a[r][c]);
			}
		}

		int result = Integer.MAX_VALUE;
		for (int target = minValue; target <= maxValue; target += d) {
			result = Math.min(result, computeMoveNum(a, d, target));
		}
		return result;
	}

	static int computeMoveNum(int[][] a, int d, int target) {
		int n = a.length;
		int m = a[0].length;

		int moveNum = 0;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				moveNum += Math.abs(a[r][c] - target) / d;
			}
		}
		return moveNum;
	}
}
