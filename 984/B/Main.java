import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static final int[] R_OFFSETS = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static final int[] C_OFFSETS = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] cells = new char[n][m];
		for (int r = 0; r < n; r++) {
			String line = sc.next();
			for (int c = 0; c < m; c++) {
				cells[r][c] = line.charAt(c);
			}
		}
		System.out.println(solve(cells) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(char[][] cells) {
		int n = cells.length;
		int m = cells[0].length;

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (cells[r][c] == '*') {
					continue;
				}

				int bombCount;
				if (cells[r][c] == '.') {
					bombCount = 0;
				} else {
					bombCount = cells[r][c] - '0';
				}

				if (countBomb(cells, r, c) != bombCount) {
					return false;
				}
			}
		}

		return true;
	}

	static int countBomb(char[][] cells, int r, int c) {
		int n = cells.length;
		int m = cells[0].length;

		return (int) IntStream.range(0, R_OFFSETS.length).filter(i -> {
			int adjR = r + R_OFFSETS[i];
			int adjC = c + C_OFFSETS[i];

			return adjR >= 0 && adjR < n && adjC >= 0 && adjC < m && cells[adjR][adjC] == '*';
		}).count();
	}
}
