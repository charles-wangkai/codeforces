import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] matrix = new char[n][m];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				matrix[r][c] = sc.next().charAt(0);
			}
		}
		System.out.println(solve(matrix));

		sc.close();
	}

	static String solve(char[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if ("CMY".indexOf(matrix[r][c]) >= 0) {
					return "#Color";
				}
			}
		}
		return "#Black&White";
	}
}
