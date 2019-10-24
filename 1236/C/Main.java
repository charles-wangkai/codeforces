import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static String solve(int n) {
		int[][] result = new int[n][n];
		int number = 1;
		int r = 0;
		for (int c = 0; c < n; c++) {
			int offset = (c % 2 == 0) ? 1 : -1;

			result[r][c] = number;
			number++;

			for (int i = 0; i < n - 1; i++) {
				r += offset;

				result[r][c] = number;
				number++;
			}
		}

		return Arrays.stream(result)
				.map(row -> Arrays.stream(row).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
				.collect(Collectors.joining("\n"));
	}
}
