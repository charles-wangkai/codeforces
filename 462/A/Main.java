import java.util.Scanner;

public class Main {
	static final int[] R_OFFSETS = { -1, 0, 1, 0 };
	static final int[] C_OFFSETS = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		char[][] checkerboard = new char[n][n];
		for (int r = 0; r < n; r++) {
			String line = sc.next();

			for (int c = 0; c < n; c++) {
				checkerboard[r][c] = line.charAt(c);
			}
		}
		System.out.println(solve(checkerboard) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(char[][] checkerboard) {
		int n = checkerboard.length;

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				int adjONum = 0;
				for (int i = 0; i < R_OFFSETS.length; i++) {
					int adjR = r + R_OFFSETS[i];
					int adjC = c + C_OFFSETS[i];

					if (adjR >= 0 && adjR < n && adjC >= 0 && adjC < n && checkerboard[adjR][adjC] == 'o') {
						adjONum++;
					}
				}

				if (adjONum % 2 != 0) {
					return false;
				}
			}
		}

		return true;
	}
}
