import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final int SIZE = 3;
	static final int[] R_OFFSETS = { 0, -1, 0, 1, 0 };
	static final int[] C_OFFSETS = { 0, 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] pressNums = new int[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				pressNums[i][j] = sc.nextInt();
			}
		}
		System.out.print(solve(pressNums));

		sc.close();
	}

	static String solve(int[][] pressNums) {
		boolean[][] lights = new boolean[SIZE][SIZE];
		Arrays.stream(lights).forEach(row -> Arrays.fill(row, true));

		for (int r = 0; r < SIZE; r++) {
			for (int c = 0; c < SIZE; c++) {
				if (pressNums[r][c] % 2 != 0) {
					press(lights, r, c);
				}
			}
		}

		StringBuilder result = new StringBuilder();
		for (int r = 0; r < SIZE; r++) {
			for (int c = 0; c < SIZE; c++) {
				result.append(lights[r][c] ? '1' : '0');
			}
			result.append('\n');
		}
		return result.toString();
	}

	static void press(boolean[][] lights, int r, int c) {
		for (int i = 0; i < R_OFFSETS.length; i++) {
			int adjR = r + R_OFFSETS[i];
			int adjC = c + C_OFFSETS[i];

			if (adjR >= 0 && adjR < SIZE && adjC >= 0 && adjC < SIZE) {
				lights[adjR][adjC] = !lights[adjR][adjC];
			}
		}
	}
}
