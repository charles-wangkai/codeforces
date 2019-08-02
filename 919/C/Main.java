import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		char[][] matrix = new char[n][m];
		for (int r = 0; r < n; r++) {
			String line = sc.next();
			for (int c = 0; c < m; c++) {
				matrix[r][c] = line.charAt(c);
			}
		}
		System.out.println(solve(matrix, k));

		sc.close();
	}

	static int solve(char[][] matrix, int k) {
		int n = matrix.length;
		int m = matrix[0].length;

		int[][] rowCounts = new int[n][m];
		for (int r = 0; r < n; r++) {
			int rowCount = 0;
			for (int c = 0; c < m; c++) {
				if (matrix[r][c] == '*') {
					rowCount++;
				}

				rowCounts[r][c] = rowCount;
			}
		}

		int[][] colCounts = new int[n][m];
		for (int c = 0; c < m; c++) {
			int colCount = 0;
			for (int r = 0; r < n; r++) {
				if (matrix[r][c] == '*') {
					colCount++;
				}

				colCounts[r][c] = colCount;
			}
		}

		int result = 0;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (c + k - 1 < m && rowCounts[r][c + k - 1] == (c == 0 ? 0 : rowCounts[r][c - 1])) {
					result++;
				}

				if (k != 1 && r + k - 1 < n && colCounts[r + k - 1][c] == (r == 0 ? 0 : colCounts[r - 1][c])) {
					result++;
				}
			}
		}
		return result;
	}
}
