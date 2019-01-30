import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int r = sc.nextInt();
		int c = sc.nextInt();
		char[][] cells = new char[r][c];
		for (int i = 0; i < r; i++) {
			String line = sc.next();
			for (int j = 0; j < c; j++) {
				cells[i][j] = line.charAt(j);
			}
		}
		System.out.println(solve(cells));

		sc.close();
	}

	static int solve(char[][] cells) {
		int r = cells.length;
		int c = cells[0].length;

		int safeRowNum = (int) Arrays.stream(cells).filter(row -> IntStream.range(0, c).allMatch(j -> row[j] == '.'))
				.count();
		int safeColNum = (int) IntStream.range(0, c)
				.filter(j -> IntStream.range(0, r).allMatch(i -> cells[i][j] == '.')).count();

		return safeRowNum * c + safeColNum * r - safeRowNum * safeColNum;
	}
}
