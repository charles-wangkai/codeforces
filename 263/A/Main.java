import java.util.Scanner;

public class Main {
	static final int SIZE = 5;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] matrix = new int[SIZE][SIZE];
		for (int r = 0; r < SIZE; r++) {
			for (int c = 0; c < SIZE; c++) {
				matrix[r][c] = sc.nextInt();
			}
		}
		System.out.println(solve(matrix));

		sc.close();
	}

	static int solve(int[][] matrix) {
		for (int r = 0;; r++) {
			for (int c = 0; c < SIZE; c++) {
				if (matrix[r][c] == 1) {
					return Math.abs(r - 2) + Math.abs(c - 2);
				}
			}
		}
	}
}
