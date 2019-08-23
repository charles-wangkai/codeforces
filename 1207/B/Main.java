import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	static final int[] R_OFFSETS = { -1, -1, 0, 0 };
	static final int[] C_OFFSETS = { -1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] A = new int[n][m];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				A[r][c] = sc.nextInt();
			}
		}
		System.out.print(solve(A));

		sc.close();
	}

	static String solve(int[][] A) {
		int n = A.length;
		int m = A[0].length;

		Set<String> operations = new HashSet<>();
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (A[r][c] == 1) {
					String operation = findOperation(A, r, c);
					if (operation == null) {
						return "-1";
					}

					operations.add(operation);
				}
			}
		}

		return String.format("%d\n%s", operations.size(),
				operations.stream().map(String::valueOf).collect(Collectors.joining("\n")));
	}

	static String findOperation(int[][] A, int r, int c) {
		int n = A.length;
		int m = A[0].length;

		for (int i = 0; i < R_OFFSETS.length; i++) {
			int x = r + R_OFFSETS[i];
			int y = c + C_OFFSETS[i];

			if (x >= 0 && x < n && y >= 0 && y < m && IntStream.range(0, R_OFFSETS.length).allMatch(j -> {
				int adjR = x - R_OFFSETS[j];
				int adjC = y - C_OFFSETS[j];

				return adjR >= 0 && adjR < n && adjC >= 0 && adjC < m && A[adjR][adjC] == 1;
			})) {
				return String.format("%d %d", x + 1, y + 1);
			}
		}

		return null;
	}
}
