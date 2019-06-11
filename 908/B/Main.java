import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] maze = new char[n][m];
		for (int r = 0; r < n; r++) {
			String line = sc.next();
			for (int c = 0; c < m; c++) {
				maze[r][c] = line.charAt(c);
			}
		}
		String s = sc.next();
		System.out.println(solve(maze, s));

		sc.close();
	}

	static int solve(char[][] maze, String s) {
		return search(maze, s, new Direction[] { new Direction(-1, 0), new Direction(0, 1), new Direction(1, 0),
				new Direction(0, -1) }, 0);
	}

	static int search(char[][] maze, String s, Direction[] directions, int index) {
		if (index == directions.length) {
			return isValid(maze, s, directions) ? 1 : 0;
		}

		int result = 0;
		for (int i = index; i < directions.length; i++) {
			swap(directions, i, index);

			result += search(maze, s, directions, index + 1);

			swap(directions, i, index);
		}
		return result;
	}

	static void swap(Direction[] directions, int index1, int index2) {
		Direction temp = directions[index1];
		directions[index1] = directions[index2];
		directions[index2] = temp;
	}

	static boolean isValid(char[][] maze, String s, Direction[] directions) {
		int n = maze.length;
		int m = maze[0].length;

		int r = 0;
		int c = 0;
		while (maze[r][c] != 'S') {
			c++;

			if (c == m) {
				r++;
				c = 0;
			}
		}

		for (int i = 0; i < s.length(); i++) {
			Direction direction = directions[s.charAt(i) - '0'];

			r += direction.rOffset;
			c += direction.cOffset;

			if (!(r >= 0 && r < n && c >= 0 && c < m) || maze[r][c] == '#') {
				return false;
			} else if (maze[r][c] == 'E') {
				return true;
			}
		}

		return false;
	}
}

class Direction {
	int rOffset;
	int cOffset;

	Direction(int rOffset, int cOffset) {
		this.rOffset = rOffset;
		this.cOffset = cOffset;
	}
}