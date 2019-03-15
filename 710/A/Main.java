import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static final int SIZE = 8;
	static final int[] R_OFFSETS = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static final int[] C_OFFSETS = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String location = sc.next();
		System.out.println(solve(location));

		sc.close();
	}

	static int solve(String location) {
		int r = location.charAt(0) - 'a';
		int c = location.charAt(1) - '1';

		return (int) IntStream.range(0, R_OFFSETS.length).filter(i -> {
			int adjR = r + R_OFFSETS[i];
			int adjC = c + C_OFFSETS[i];

			return adjR >= 0 && adjR < SIZE && adjC >= 0 && adjC < SIZE;
		}).count();
	}
}
