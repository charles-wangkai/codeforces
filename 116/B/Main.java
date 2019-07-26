import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static final int[] R_OFFSETS = { -1, 0, 1, 0 };
	static final int[] C_OFFSETS = { 0, 1, 0, -1 };

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
		System.out.println(solve(grid));

		sc.close();
	}

	static int solve(char[][] grid) {
		int n = grid.length;
		int m = grid[0].length;

		return IntStream.range(0, n).map(r -> (int) IntStream.range(0, m)
				.filter(c -> grid[r][c] == 'W' && IntStream.range(0, R_OFFSETS.length).anyMatch(i -> {
					int adjR = r + R_OFFSETS[i];
					int adjC = c + C_OFFSETS[i];

					return adjR >= 0 && adjR < n && adjC >= 0 && adjC < m && grid[adjR][adjC] == 'P';
				})).count()).sum();
	}
}
