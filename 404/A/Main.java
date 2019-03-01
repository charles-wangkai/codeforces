import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		char[][] square = new char[n][n];
		for (int r = 0; r < n; r++) {
			String line = sc.next();

			for (int c = 0; c < n; c++) {
				square[r][c] = line.charAt(c);
			}
		}
		System.out.println(solve(square) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(char[][] square) {
		int n = square.length;

		return square[0][0] != square[0][1] && IntStream.range(0, n).allMatch(r -> IntStream.range(0, n)
				.allMatch(c -> square[r][c] == ((r == c || r + c == n - 1) ? square[0][0] : square[0][1])));
	}
}
