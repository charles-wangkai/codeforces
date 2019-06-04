import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	static final char[] VOWELS = { 'a', 'e', 'i', 'o', 'u' };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		System.out.println(solve(k));

		sc.close();
	}

	static String solve(int k) {
		for (int row = VOWELS.length; row * row <= k; row++) {
			if (k % row == 0) {
				int col = k / row;

				char[][] grid = new char[row][col];
				for (int r = 0; r < row; r++) {
					for (int c = 0; c < col; c++) {
						grid[r][c] = VOWELS[(r + c) % VOWELS.length];
					}
				}

				return Arrays.stream(grid).map(String::new).collect(Collectors.joining());
			}
		}

		return "-1";
	}
}
