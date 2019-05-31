import java.util.Scanner;

public class Main {
	static final int[] R_OFFSETS = { -1, 0, 1, 0 };
	static final int[] C_OFFSETS = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] dots = new char[n][m];
		for (int r = 0; r < n; r++) {
			String line = sc.next();
			for (int c = 0; c < m; c++) {
				dots[r][c] = line.charAt(c);
			}
		}
		System.out.println(solve(dots) ? "Yes" : "No");

		sc.close();
	}

	static boolean solve(char[][] dots) {
		int n = dots.length;
		int m = dots[0].length;

		boolean[][] visited = new boolean[n][m];
		for (int beginR = 0; beginR < n; beginR++) {
			for (int beginC = 0; beginC < m; beginC++) {
				for (int i = 0; i < R_OFFSETS.length; i++) {
					int endR = beginR + R_OFFSETS[i];
					int endC = beginC + C_OFFSETS[i];

					if (endR >= 0 && endR < n && endC >= 0 && endC < m && dots[endR][endC] == dots[beginR][beginC]
							&& canReach(dots, visited, beginR, beginC, endR, endC, beginR, beginC)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	static boolean canReach(char[][] dots, boolean[][] visited, int beginR, int beginC, int endR, int endC, int r,
			int c) {
		int n = dots.length;
		int m = dots[0].length;

		visited[r][c] = true;

		if (r == endR && c == endC) {
			return true;
		}

		for (int i = 0; i < R_OFFSETS.length; i++) {
			int adjR = r + R_OFFSETS[i];
			int adjC = c + C_OFFSETS[i];

			if (adjR >= 0 && adjR < n && adjC >= 0 && adjC < m && dots[adjR][adjC] == dots[r][c] && !visited[adjR][adjC]
					&& !(r == beginR && c == beginC && adjR == endR && adjC == endC)
					&& canReach(dots, visited, beginR, beginC, endR, endC, adjR, adjC)) {
				return true;
			}
		}

		visited[r][c] = false;
		return false;
	}
}
