import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] table = new char[n][m];
		for (int r = 0; r < n; r++) {
			String line = sc.next();
			for (int c = 0; c < m; c++) {
				table[r][c] = line.charAt(c);
			}
		}
		System.out.println(solve(table));

		sc.close();
	}

	static int solve(char[][] table) {
		int n = table.length;
		int m = table[0].length;

		StringBuilder[] rows = IntStream.range(0, n).mapToObj(i -> new StringBuilder()).toArray(StringBuilder[]::new);
		for (int c = 0; c < m; c++) {
			for (int r = 0; r < n; r++) {
				rows[r].append(table[r][c]);
			}

			if (!IntStream.range(0, n - 1).allMatch(r -> rows[r].toString().compareTo(rows[r + 1].toString()) <= 0)) {
				for (int r = 0; r < n; r++) {
					rows[r].deleteCharAt(rows[r].length() - 1);
				}
			}
		}

		return m - rows[0].length();
	}
}
