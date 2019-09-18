import java.util.Arrays;
import java.util.Scanner;

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
		System.out.println(solve(board) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(char[][] board) {
		return Arrays.stream(board).allMatch(row -> {
			String s = new String(row);

			return s.equals("WBWBWBWB") || s.equals("BWBWBWBW");
		});
	}
}
