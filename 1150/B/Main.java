import java.util.Scanner;

public class Main {
	static final int[] R_OFFSETS = { 0, 1, 1, 1, 2 };
	static final int[] C_OFFSETS = { 0, -1, 0, 1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		char[][] board = new char[n][n];
		for (int r = 0; r < n; r++) {
			String line = sc.next();

			for (int c = 0; c < n; c++) {
				board[r][c] = line.charAt(c);
			}
		}
		System.out.println(solve(board) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(char[][] board) {
		int n = board.length;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (board[r][c] == '.' && !fill(board, r, c)) {
					return false;
				}
			}
		}
		return true;
	}

	static boolean fill(char[][] board, int topR, int topC) {
		int n = board.length;

		for (int i = 0; i < R_OFFSETS.length; i++) {
			int r = topR + R_OFFSETS[i];
			int c = topC + C_OFFSETS[i];

			if (!(r >= 0 && r < n && c >= 0 && c < n && board[r][c] == '.')) {
				return false;
			}

			board[r][c] = '#';
		}
		return true;
	}
}
