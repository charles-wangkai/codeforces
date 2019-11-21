import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static final int SIZE = 8;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[][] board = new char[SIZE][SIZE];
		for (int r = 0; r < SIZE; r++) {
			String line = sc.next();
			for (int c = 0; c < SIZE; c++) {
				board[r][c] = line.charAt(c);
			}
		}
		System.out.println(solve(board));

		sc.close();
	}

	static char solve(char[][] board) {
		int whiteDistance = Integer.MAX_VALUE;
		int blackDistance = Integer.MAX_VALUE;
		for (int r = 0; r < SIZE; r++) {
			for (int c = 0; c < SIZE; c++) {
				if (board[r][c] == 'W' && isAllEmpty(board, 0, r - 1, c)) {
					whiteDistance = Math.min(whiteDistance, r);
				} else if (board[r][c] == 'B' && isAllEmpty(board, r + 1, 7, c)) {
					blackDistance = Math.min(blackDistance, 7 - r);
				}
			}
		}

		return (whiteDistance <= blackDistance) ? 'A' : 'B';
	}

	static boolean isAllEmpty(char[][] board, int minR, int maxR, int c) {
		return IntStream.rangeClosed(minR, maxR).allMatch(r -> board[r][c] == '.');
	}
}
