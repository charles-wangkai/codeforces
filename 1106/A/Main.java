import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static final int[] R_OFFSETS = { -1, -1, 0, 1, 1 };
	static final int[] C_OFFSETS = { -1, 1, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		char[][] matrix = new char[n][n];
		for (int r = 0; r < n; r++) {
			String line = sc.next();

			for (int c = 0; c < n; c++) {
				matrix[r][c] = line.charAt(c);
			}
		}
		System.out.println(solve(matrix));

		sc.close();
	}

	static int solve(char[][] matrix) {
		int n = matrix.length;

		return IntStream
				.range(1, n - 1).map(
						r -> (int) IntStream.range(1, n - 1)
								.filter(c -> IntStream.range(0, R_OFFSETS.length)
										.allMatch(i -> matrix[r + R_OFFSETS[i]][c + C_OFFSETS[i]] == 'X'))
								.count())
				.sum();
	}
}
