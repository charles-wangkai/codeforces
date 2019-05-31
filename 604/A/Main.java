import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static final int[] POINTS = { 500, 1000, 1500, 2000, 2500 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] m = readArray(sc, POINTS.length);
		int[] w = readArray(sc, POINTS.length);
		int hs = sc.nextInt();
		int hu = sc.nextInt();
		System.out.println(solve(m, w, hs, hu));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}

	static int solve(int[] m, int[] w, int hs, int hu) {
		return IntStream.range(0, POINTS.length)
				.map(i -> Math.max(POINTS[i] * 3 / 10, POINTS[i] - POINTS[i] * m[i] / 250 - 50 * w[i])).sum() + 100 * hs
				- 50 * hu;
	}
}
