import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int S = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, S));

		sc.close();
	}

	static String solve(int[] a, int S) {
		int k = -1;
		int T = -1;
		int lower = 0;
		int upper = a.length;
		while (lower <= upper) {
			int middle = (lower + upper) / 2;

			long cost = computeCost(a, middle);
			if (cost <= S) {
				k = middle;
				T = (int) cost;

				lower = middle + 1;
			} else {
				upper = middle - 1;
			}
		}

		return String.format("%d %d", k, T);
	}

	static long computeCost(int[] a, int buyCount) {
		return IntStream.range(0, a.length).mapToObj(i -> a[i] + (i + 1L) * buyCount).sorted().limit(buyCount)
				.mapToLong(x -> x).sum();
	}
}
