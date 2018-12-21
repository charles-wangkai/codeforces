import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		Arrays.stream(solve(n, m)).forEach(row -> System.out.println(new String(row)));

		sc.close();
	}

	static char[][] solve(int n, int m) {
		char[][] cells = new char[n][m];
		int index = m - 1;
		for (int r = 0; r < cells.length; r++) {
			if (r % 2 == 0) {
				for (int c = 0; c < cells[r].length; c++) {
					cells[r][c] = '#';
				}
			} else {
				for (int c = 0; c < cells[r].length; c++) {
					cells[r][c] = (c == index) ? '#' : '.';
				}

				index = m - 1 - index;
			}
		}
		return cells;
	}
}
