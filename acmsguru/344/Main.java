import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static final int[] R_OFFSETS = { -1, 0, 1, 0 };
	static final int[] C_OFFSETS = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] squares = new char[N][M];
		for (int r = 0; r < N; ++r) {
			String line = sc.next();
			for (int c = 0; c < M; ++c) {
				squares[r][c] = line.charAt(c);
			}
		}
		System.out.println(solve(squares));

		sc.close();
	}

	static int solve(char[][] squares) {
		int N = squares.length;
		int M = squares[0].length;

		Queue<Point> queue = new LinkedList<>();
		for (int r = 0; r < N; ++r) {
			for (int c = 0; c < M; ++c) {
				if (squares[r][c] == 'X') {
					queue.offer(new Point(r, c));
				}
			}
		}

		while (!queue.isEmpty()) {
			Point head = queue.poll();

			for (int i = 0; i < R_OFFSETS.length; ++i) {
				int adjR = head.r + R_OFFSETS[i];
				int adjC = head.c + C_OFFSETS[i];

				if (adjR >= 0 && adjR < N && adjC >= 0 && adjC < M && squares[adjR][adjC] == '.'
						&& computeAdjWeedNum(squares, adjR, adjC) >= 2) {
					squares[adjR][adjC] = 'X';
					queue.offer(new Point(adjR, adjC));
				}
			}
		}

		int result = 0;
		for (int r = 0; r < N; ++r) {
			for (int c = 0; c < M; ++c) {
				if (squares[r][c] == 'X') {
					result++;
				}
			}
		}

		return result;
	}

	static int computeAdjWeedNum(char[][] squares, int r, int c) {
		int N = squares.length;
		int M = squares[0].length;

		int result = 0;
		for (int i = 0; i < R_OFFSETS.length; ++i) {
			int adjR = r + R_OFFSETS[i];
			int adjC = c + C_OFFSETS[i];

			if (adjR >= 0 && adjR < N && adjC >= 0 && adjC < M && squares[adjR][adjC] == 'X') {
				result++;
			}
		}

		return result;
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