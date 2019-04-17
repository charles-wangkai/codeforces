import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		char[][] cells = new char[n][n];
		for (int r = 0; r < n; r++) {
			String line = sc.next();

			for (int c = 0; c < n; c++) {
				cells[r][c] = line.charAt(c);
			}
		}
		System.out.println(solve(cells));

		sc.close();
	}

	static int solve(char[][] cells) {
		int n = cells.length;

		int result = 0;
		for (int r = 0; r < n; r++) {
			int chocolateNum = countRow(cells, r);

			result += chocolateNum * (chocolateNum - 1) / 2;
		}
		for (int c = 0; c < n; c++) {
			int chocolateNum = countColumn(cells, c);

			result += chocolateNum * (chocolateNum - 1) / 2;
		}
		return result;
	}

	static int countRow(char[][] cells, int r) {
		return (int) IntStream.range(0, cells.length).filter(c -> cells[r][c] == 'C').count();
	}

	static int countColumn(char[][] cells, int c) {
		return (int) IntStream.range(0, cells.length).filter(r -> cells[r][c] == 'C').count();
	}
}
