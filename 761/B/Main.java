import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int L = sc.nextInt();
		int[] distances1 = readArray(sc, n);
		int[] distances2 = readArray(sc, n);
		System.out.println(solve(distances1, distances2, L) ? "YES" : "NO");

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}

		return result;
	}

	static boolean solve(int[] distances1, int[] distances2, int L) {
		return isSame(buildIntervals(distances1, L), buildIntervals(distances2, L));
	}

	static int[] buildIntervals(int[] distances, int L) {
		return IntStream.concat(IntStream.range(0, distances.length - 1).map(i -> distances[i + 1] - distances[i]),
				IntStream.of(L - distances[distances.length - 1] + distances[0])).toArray();
	}

	static boolean isSame(int[] intervals1, int[] intervals2) {
		int n = intervals1.length;

		return IntStream.range(0, n)
				.anyMatch(offset -> IntStream.range(0, n).allMatch(i -> intervals1[i] == intervals2[(i + offset) % n]));
	}
}
