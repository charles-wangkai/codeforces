import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final int SIZE = 4;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();
		char[][] panels = new char[SIZE][SIZE];
		for (int r = 0; r < SIZE; r++) {
			String line = sc.next();
			for (int c = 0; c < SIZE; c++) {
				panels[r][c] = line.charAt(c);
			}
		}
		System.out.println(solve(k, panels) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int k, char[][] panels) {
		int[] counts = new int[10];
		for (int r = 0; r < SIZE; r++) {
			for (int c = 0; c < SIZE; c++) {
				if (panels[r][c] != '.') {
					counts[panels[r][c] - '0']++;
				}
			}
		}

		return Arrays.stream(counts).allMatch(count -> count <= k * 2);
	}
}
