import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static final int[] R_OFFSETS = { -1, 0, 1, 0 };
	static final int[] C_OFFSETS = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int h = sc.nextInt();
		int w = sc.nextInt();
		char[][] cells = new char[h][w];
		for (int r = 0; r < h; r++) {
			String line = sc.next();
			for (int c = 0; c < w; c++) {
				cells[r][c] = line.charAt(c);
			}
		}
		System.out.println(solve(cells) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(char[][] cells) {
		int h = cells.length;
		int w = cells[0].length;

		int starCount = IntStream.range(0, h)
				.map(r -> (int) IntStream.range(0, w).filter(c -> cells[r][c] == '*').count()).sum();

		for (int r = 1; r < h - 1; r++) {
			for (int c = 1; c < w - 1; c++) {
				if (cells[r][c] == '*' && cells[r - 1][c] == '*' && cells[r][c - 1] == '*') {
					return cells[r + 1][c] == '*' && cells[r][c + 1] == '*'
							&& computeCoveredCount(cells, r, c) == starCount;
				}
			}
		}

		return false;
	}

	static int computeCoveredCount(char[][] cells, int r, int c) {
		return IntStream.range(0, R_OFFSETS.length).map(i -> computeRayLength(cells, r, c, R_OFFSETS[i], C_OFFSETS[i]))
				.sum() + 1;
	}

	static int computeRayLength(char[][] cells, int r, int c, int offsetR, int offsetC) {
		int h = cells.length;
		int w = cells[0].length;

		int result = 0;
		while (true) {
			r += offsetR;
			c += offsetC;

			if (!(r >= 0 && r < h && c >= 0 && c < w && cells[r][c] == '*')) {
				return result;
			}

			result++;
		}
	}
}
