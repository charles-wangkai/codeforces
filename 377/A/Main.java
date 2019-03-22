import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static final int[] R_OFFSETS = { -1, 0, 1, 0 };
	static final int[] C_OFFSETS = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		char[][] maze = new char[n][m];
		for (int r = 0; r < n; r++) {
			String line = sc.next();
			for (int c = 0; c < m; c++) {
				maze[r][c] = line.charAt(c);
			}
		}
		System.out.println(String.join("\n", Arrays.stream(solve(maze, k)).map(String::new).toArray(String[]::new)));

		sc.close();
	}

	static char[][] solve(char[][] maze, int k) {
		int n = maze.length;
		int m = maze[0].length;

		Point start = findAnyEmptyCell(maze);

		List<Point> paths = new ArrayList<>();
		dfs(maze, paths, new boolean[n][m], start.r, start.c);

		for (int i = paths.size() - 1; i >= paths.size() - k; i--) {
			Point point = paths.get(i);
			maze[point.r][point.c] = 'X';
		}

		return maze;
	}

	static Point findAnyEmptyCell(char[][] maze) {
		for (int r = 0;; r++) {
			for (int c = 0; c < maze[r].length; c++) {
				if (maze[r][c] == '.') {
					return new Point(r, c);
				}
			}
		}
	}

	static void dfs(char[][] maze, List<Point> paths, boolean[][] visited, int r, int c) {
		int n = maze.length;
		int m = maze[0].length;

		paths.add(new Point(r, c));
		visited[r][c] = true;

		for (int i = 0; i < R_OFFSETS.length; i++) {
			int adjR = r + R_OFFSETS[i];
			int adjC = c + C_OFFSETS[i];

			if (adjR >= 0 && adjR < n && adjC >= 0 && adjC < m && maze[adjR][adjC] == '.' && !visited[adjR][adjC]) {
				dfs(maze, paths, visited, adjR, adjC);
			}
		}
	}
}

class Point {
	int r;
	int c;

	Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
}