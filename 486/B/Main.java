import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] B = new int[m][n];
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				B[r][c] = sc.nextInt();
			}
		}
		System.out.print(solve(B));

		sc.close();
	}

	static String solve(int[][] B) {
		int[][] A = produce(B, 1, 0);

		if (isSame(produce(A, 0, 1), B)) {
			return String.format("YES\n%s",
					Arrays.stream(A)
							.map(row -> Arrays.stream(row).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
							.collect(Collectors.joining("\n")));
		} else {
			return "NO";
		}
	}

	static int[][] produce(int[][] matrix, int initialValue, int lookupValue) {
		int m = matrix.length;
		int n = matrix[0].length;

		int[][] result = new int[m][n];
		IntStream.range(0, m).forEach(r -> Arrays.fill(result[r], initialValue));

		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				if (matrix[r][c] == lookupValue) {
					for (int j = 0; j < n; j++) {
						result[r][j] = lookupValue;
					}
					for (int i = 0; i < m; i++) {
						result[i][c] = lookupValue;
					}
				}
			}
		}

		return result;
	}

	static boolean isSame(int[][] matrix1, int[][] matrix2) {
		int m = matrix1.length;
		int n = matrix2[0].length;

		return IntStream.range(0, m).allMatch(r -> IntStream.range(0, n).allMatch(c -> matrix1[r][c] == matrix2[r][c]));
	}
}
