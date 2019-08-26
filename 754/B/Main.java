import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static final int SIZE = 4;
	static final int[] R_OFFSETS = { 0, 1, 1, 1 };
	static final int[] C_OFFSETS = { 1, 0, 1, -1 };

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
		return IntStream.range(0, SIZE)
				.anyMatch(r -> IntStream.range(0, SIZE).anyMatch(c -> cells[r][c] == '.' && willWin(cells, r, c)));
	}

	static boolean willWin(char[][] cells, int moveR, int moveC) {
		return IntStream.range(0, R_OFFSETS.length).anyMatch(i -> {
			int rOffset = R_OFFSETS[i];
			int cOffset = C_OFFSETS[i];

			return (isX(cells, moveR - 2 * rOffset, moveC - 2 * cOffset)
					&& isX(cells, moveR - rOffset, moveC - cOffset))
					|| (isX(cells, moveR - rOffset, moveC - cOffset) && isX(cells, moveR + rOffset, moveC + cOffset))
					|| (isX(cells, moveR + rOffset, moveC + cOffset)
							&& isX(cells, moveR + 2 * rOffset, moveC + 2 * cOffset));
		});
	}

	static boolean isX(char[][] cells, int r, int c) {
		return r >= 0 && r < SIZE && c >= 0 && c < SIZE && cells[r][c] == 'x';
	}
}
