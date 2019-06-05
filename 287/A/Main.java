import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	static final int SIZE = 4;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[][] cells = new char[SIZE][SIZE];
		for (int r = 0; r < SIZE; r++) {
			String line = sc.next();
			for (int c = 0; c < SIZE; c++) {
				cells[r][c] = line.charAt(c);
			}
		}
		System.out.println(solve(cells) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(char[][] cells) {
		return IntStream.range(0, SIZE - 1).anyMatch(r -> IntStream.range(0, SIZE - 1)
				.anyMatch(c -> Stream.of(cells[r][c], cells[r][c + 1], cells[r + 1][c], cells[r + 1][c + 1])
						.filter(cell -> cell == '.').count() != 2));
	}
}
