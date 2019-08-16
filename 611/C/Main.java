import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();
		char[][] grid = new char[h][w];
		for (int r = 0; r < h; r++) {
			String line = sc.next();
			for (int c = 0; c < w; c++) {
				grid[r][c] = line.charAt(c);
			}
		}
		int q = sc.nextInt();
		int[] r1 = new int[q];
		int[] c1 = new int[q];
		int[] r2 = new int[q];
		int[] c2 = new int[q];
		for (int i = 0; i < q; i++) {
			r1[i] = sc.nextInt() - 1;
			c1[i] = sc.nextInt() - 1;
			r2[i] = sc.nextInt() - 1;
			c2[i] = sc.nextInt() - 1;
		}
		System.out.print(solve(grid, r1, c1, r2, c2));

		sc.close();
	}

	static String solve(char[][] grid, int[] r1, int[] c1, int[] r2, int[] c2) {
		int[][] horizontalPrefixSums = buildPrefixSums(buildHorizontal(grid));
		int[][] verticalPrefixSums = buildPrefixSums(buildVertical(grid));

		int[] result = new int[r1.length];
		for (int i = 0; i < r1.length; i++) {
			result[i] = computeRangeSum(horizontalPrefixSums, r1[i], c1[i], r2[i], c2[i] - 1)
					+ computeRangeSum(verticalPrefixSums, r1[i], c1[i], r2[i] - 1, c2[i]);
		}

		return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
	}

	static int[][] buildHorizontal(char[][] grid) {
		int h = grid.length;
		int w = grid[0].length;

		int[][] horizontal = new int[h][w];
		for (int r = 0; r < h; r++) {
			for (int c = 0; c < w - 1; c++) {
				if (grid[r][c] == '.' && grid[r][c + 1] == '.') {
					horizontal[r][c] = 1;
				}
			}
		}

		return horizontal;
	}

	static int[][] buildVertical(char[][] grid) {
		int h = grid.length;
		int w = grid[0].length;

		int[][] vertical = new int[h][w];
		for (int r = 0; r < h - 1; r++) {
			for (int c = 0; c < w; c++) {
				if (grid[r][c] == '.' && grid[r + 1][c] == '.') {
					vertical[r][c] = 1;
				}
			}
		}

		return vertical;
	}

	static int[][] buildPrefixSums(int[][] values) {
		int h = values.length;
		int w = values[0].length;

		int[][] prefixSums = new int[h][w];
		for (int r = 0; r < h; r++) {
			for (int c = 0; c < w; c++) {
				prefixSums[r][c] = ((r == 0) ? 0 : prefixSums[r - 1][c]) + ((c == 0) ? 0 : prefixSums[r][c - 1])
						- ((r == 0 || c == 0) ? 0 : prefixSums[r - 1][c - 1]) + values[r][c];
			}
		}

		return prefixSums;
	}

	static int computeRangeSum(int[][] prefixSums, int minR, int minC, int maxR, int maxC) {
		if (minR > maxR || minC > maxC) {
			return 0;
		}

		return prefixSums[maxR][maxC] - ((minR == 0) ? 0 : prefixSums[minR - 1][maxC])
				- ((minC == 0) ? 0 : prefixSums[maxR][minC - 1])
				+ ((minR == 0 || minC == 0) ? 0 : prefixSums[minR - 1][minC - 1]);
	}
}
