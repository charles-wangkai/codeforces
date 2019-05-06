import java.util.Scanner;

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

	static String solve(char[][] table) {
		int blackMinR = Integer.MAX_VALUE;
		int blackMaxR = Integer.MIN_VALUE;
		int blackMinC = Integer.MAX_VALUE;
		int blackMaxC = Integer.MIN_VALUE;

		for (int r = 0; r < table.length; r++) {
			for (int c = 0; c < table[0].length; c++) {
				if (table[r][c] == 'B') {
					blackMinR = Math.min(blackMinR, r);
					blackMaxR = Math.max(blackMaxR, r);
					blackMinC = Math.min(blackMinC, c);
					blackMaxC = Math.max(blackMaxC, c);
				}
			}
		}

		return String.format("%d %d", (blackMinR + blackMaxR) / 2 + 1, (blackMinC + blackMaxC) / 2 + 1);
	}
}
