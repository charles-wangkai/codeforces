import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] flag = new char[n][m];
		for (int r = 0; r < n; r++) {
			String line = sc.next();
			for (int c = 0; c < m; c++) {
				flag[r][c] = line.charAt(c);
			}
		}
		System.out.println(solve(flag) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(char[][] flag) {
		return IntStream.range(0, flag.length).allMatch(
				i -> new String(flag[i]).chars().distinct().count() == 1 && (i == 0 || flag[i][0] != flag[i - 1][0]));
	}
}
