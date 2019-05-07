import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = readArray(sc, n);
		int[] b = readArray(sc, n);
		System.out.println(solve(a, b));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}

	static int solve(int[] a, int[] b) {
		int[] aPerformanceCounts = buildPerformanceCount(a);
		int[] bPerformanceCounts = buildPerformanceCount(b);

		if (IntStream.range(0, aPerformanceCounts.length)
				.anyMatch(i -> (aPerformanceCounts[i] + bPerformanceCounts[i]) % 2 != 0)) {
			return -1;
		}

		return IntStream.range(0, aPerformanceCounts.length)
				.map(i -> Math.max(0, aPerformanceCounts[i] - (aPerformanceCounts[i] + bPerformanceCounts[i]) / 2))
				.sum();
	}

	static int[] buildPerformanceCount(int[] performances) {
		int[] result = new int[5];
		for (int performance : performances) {
			result[performance - 1]++;
		}
		return result;
	}
}
