import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.print(solve(n, k));

		sc.close();
	}

	static String solve(int n, int k) {
		int[][] table = new int[n][n];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				table[r][c] = (r == c) ? k : 0;
			}
		}

		return Arrays.stream(table)
				.map(line -> Arrays.stream(line).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
				.collect(Collectors.joining("\n"));
	}
}
