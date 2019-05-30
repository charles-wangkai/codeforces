import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		long[][] grid = new long[n][n];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				grid[r][c] = sc.nextInt();
			}
		}
		System.out.println(solve(grid));

		sc.close();
	}

	static long solve(long[][] grid) {
		int n = grid.length;

		if (n == 1) {
			return 1;
		}

		int emptyR = -1;
		int emptyC = -1;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (grid[r][c] == 0) {
					emptyR = r;
					emptyC = c;

					break;
				}
			}

			if (emptyR != -1) {
				break;
			}
		}

		long targetSum = computeSum(grid, (emptyR + 1) % n, 0, 0, 1);

		long x = targetSum - computeSum(grid, emptyR, 0, 0, 1);
		if (x <= 0) {
			return -1;
		}

		grid[emptyR][emptyC] = x;

		return isMagic(grid, targetSum) ? x : -1;
	}

	static boolean isMagic(long[][] grid, long targetSum) {
		int n = grid.length;

		return IntStream.range(0, n).allMatch(r -> computeSum(grid, r, 0, 0, 1) == targetSum)
				&& IntStream.range(0, n).allMatch(c -> computeSum(grid, 0, c, 1, 0) == targetSum)
				&& computeSum(grid, 0, 0, 1, 1) == targetSum && computeSum(grid, 0, n - 1, 1, -1) == targetSum;
	}

	static long computeSum(long[][] grid, int beginR, int beginC, int offsetR, int offsetC) {
		int n = grid.length;

		long result = 0;
		for (int r = beginR, c = beginC; r >= 0 && r < n && c >= 0 && c < n; r += offsetR, c += offsetC) {
			result += grid[r][c];
		}
		return result;
	}
}
