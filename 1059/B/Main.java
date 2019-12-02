import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static final boolean[][] PATTERN = { { true, true, true }, { true, false, true }, { true, true, true } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] grid = new char[n][m];
		for (int r = 0; r < n; r++) {
			String line = sc.next();
			for (int c = 0; c < m; c++) {
				grid[r][c] = line.charAt(c);
			}
		}
		System.out.println(solve(grid) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(char[][] grid) {
		int n = grid.length;
		int m = grid[0].length;

		char[][] filled = new char[n][m];
		for (int r = 0; r < filled.length; r++) {
			Arrays.fill(filled[r], '.');
		}

		for (int r = 0; r + PATTERN.length <= n; r++) {
			for (int c = 0; c + PATTERN[0].length <= m; c++) {
				if (canFill(grid, r, c)) {
					fill(filled, r, c);
				}
			}
		}

		return isEqual(filled, grid);
	}

	static boolean canFill(char[][] grid, int r, int c) {
		return IntStream.range(0, PATTERN.length).allMatch(
				i -> IntStream.range(0, PATTERN[0].length).allMatch(j -> !PATTERN[i][j] || grid[r + i][c + j] == '#'));
	}

	static void fill(char[][] filled, int r, int c) {
		IntStream.range(0, PATTERN.length)
				.forEach(i -> IntStream.range(0, PATTERN[0].length).filter(j -> PATTERN[i][j]).forEach(j -> {
					filled[r + i][c + j] = '#';
				}));
	}

	static boolean isEqual(char[][] filled, char[][] grid) {
		return IntStream.range(0, filled.length)
				.allMatch(r -> IntStream.range(0, filled[0].length).allMatch(c -> filled[r][c] == grid[r][c]));
	}
}
