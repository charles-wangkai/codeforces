import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	static final int SIZE = 3;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] square = new int[SIZE][SIZE];
		for (int r = 0; r < SIZE; r++) {
			for (int c = 0; c < SIZE; c++) {
				square[r][c] = sc.nextInt();
			}
		}
		System.out.print(solve(square));

		sc.close();
	}

	static String solve(int[][] square) {
		for (int i = 1;; i++) {
			square[0][0] = i;

			int sum = Arrays.stream(square[0]).sum();
			square[1][1] = sum - square[1][0] - square[1][2];
			square[2][2] = sum - square[2][0] - square[2][1];

			if (check(square)) {
				return Arrays.stream(square)
						.map(row -> Arrays.stream(row).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
						.collect(Collectors.joining("\n"));
			}
		}
	}

	static boolean check(int[][] square) {
		if (!Arrays.stream(square).allMatch(row -> Arrays.stream(row).allMatch(x -> x > 0 && x <= 100000))) {
			return false;
		}

		int sum = Arrays.stream(square[0]).sum();

		return IntStream.range(0, SIZE).allMatch(c -> IntStream.range(0, SIZE).map(r -> square[r][c]).sum() == sum)
				&& square[0][0] + square[1][1] + square[2][2] == sum
				&& square[0][2] + square[1][1] + square[2][0] == sum;
	}
}
