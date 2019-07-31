import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int q = sc.nextInt();
		for (int tc = 0; tc < q; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			char[][] cells = new char[n][m];
			for (int r = 0; r < n; r++) {
				String line = sc.next();
				for (int c = 0; c < m; c++) {
					cells[r][c] = line.charAt(c);
				}
			}

			System.out.println(solve(cells));
		}

		sc.close();
	}

	static int solve(char[][] cells) {
		int n = cells.length;
		int m = cells[0].length;

		int[] rowCounts = new int[n];
		int[] colCounts = new int[m];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (cells[r][c] == '*') {
					rowCounts[r]++;
					colCounts[c]++;
				}
			}
		}

		return IntStream.range(0, n)
				.map(r -> IntStream.range(0, m)
						.map(c -> (m - rowCounts[r]) + (n - colCounts[c]) - ((cells[r][c] == '.') ? 1 : 0)).min()
						.getAsInt())
				.min().getAsInt();
	}
}
