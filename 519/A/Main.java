import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static Map<Character, Integer> pieceToWeight = new HashMap<>();
	static {
		pieceToWeight.put('Q', 9);
		pieceToWeight.put('R', 5);
		pieceToWeight.put('B', 3);
		pieceToWeight.put('N', 3);
		pieceToWeight.put('P', 1);
		pieceToWeight.put('K', 0);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[][] board = new char[8][8];
		for (int r = 0; r < board.length; r++) {
			String line = sc.next();
			for (int c = 0; c < board[r].length; c++) {
				board[r][c] = line.charAt(c);
			}
		}
		System.out.println(solve(board));

		sc.close();
	}

	static String solve(char[][] board) {
		int whiteWeight = 0;
		int blackWeight = 0;
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				if (Character.isUpperCase(board[r][c])) {
					whiteWeight += pieceToWeight.get(board[r][c]);
				} else if (Character.isLowerCase(board[r][c])) {
					blackWeight += pieceToWeight.get(Character.toUpperCase(board[r][c]));
				}
			}
		}

		if (whiteWeight > blackWeight) {
			return "White";
		} else if (whiteWeight < blackWeight) {
			return "Black";
		} else {
			return "Draw";
		}
	}
}
