import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] chessboard = new char[n][m];
		for (int r = 0; r < n; r++) {
			String line = sc.next();

			for (int c = 0; c < m; c++) {
				chessboard[r][c] = line.charAt(c);
			}
		}
		Arrays.stream(solve(chessboard)).forEach(line -> System.out.println(new String(line)));

		sc.close();
	}

	static char[][] solve(char[][] chessboard) {
		int row = chessboard.length;
		int col = chessboard[0].length;

		char[][] result = new char[row][col];
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (chessboard[r][c] == '-') {
					result[r][c] = '-';
				} else if ((r + c) % 2 == 0) {
					result[r][c] = 'B';
				} else {
					result[r][c] = 'W';
				}
			}
		}
		return result;
	}
}
