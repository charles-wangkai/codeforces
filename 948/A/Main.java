import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	static final int[] R_OFFSETS = { -1, 0, 1, 0 };
	static final int[] C_OFFSETS = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int R = sc.nextInt();
		int C = sc.nextInt();
		char[][] cells = new char[R][C];
		for (int r = 0; r < R; r++) {
			String line = sc.next();
			for (int c = 0; c < C; c++) {
				cells[r][c] = line.charAt(c);
			}
		}
		System.out.print(solve(cells));

		sc.close();
	}

	static String solve(char[][] cells) {
		int R = cells.length;
		int C = cells[0].length;

		if (IntStream.range(0, R).anyMatch(r -> IntStream.range(0, C)
				.anyMatch(c -> cells[r][c] == 'W' && IntStream.range(0, R_OFFSETS.length).anyMatch(i -> {
					int adjR = r + R_OFFSETS[i];
					int adjC = c + C_OFFSETS[i];

					return adjR >= 0 && adjR < R && adjC >= 0 && adjC < C && cells[adjR][adjC] == 'S';
				})))) {
			return "No";
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (cells[r][c] == '.') {
					cells[r][c] = 'D';
				}
			}
		}

		return String.format("Yes\n%s", Arrays.stream(cells).map(String::new).collect(Collectors.joining("\n")));
	}
}
