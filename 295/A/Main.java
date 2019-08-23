import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		int[] l = new int[m];
		int[] r = new int[m];
		int[] d = new int[m];
		for (int i = 0; i < m; i++) {
			l[i] = sc.nextInt() - 1;
			r[i] = sc.nextInt() - 1;
			d[i] = sc.nextInt();
		}
		int[] x = new int[k];
		int[] y = new int[k];
		for (int i = 0; i < k; i++) {
			x[i] = sc.nextInt() - 1;
			y[i] = sc.nextInt() - 1;
		}
		System.out.println(solve(a, l, r, d, x, y));

		sc.close();
	}

	static String solve(int[] a, int[] l, int[] r, int[] d, int[] x, int[] y) {
		int m = l.length;
		int k = x.length;

		long[] operationNums = batchModify(new int[m], x, y, IntStream.range(0, k).mapToLong(i -> 1).toArray());
		long[] additions = IntStream.range(0, m).mapToLong(i -> d[i] * operationNums[i]).toArray();
		long[] result = batchModify(a, l, r, additions);

		return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
	}

	static long[] batchModify(int[] initial, int[] beginIndices, int[] endIndices, long[] additions) {
		int length = initial.length;

		long[] deltas = new long[length];
		for (int i = 0; i < beginIndices.length; i++) {
			deltas[beginIndices[i]] += additions[i];

			if (endIndices[i] != length - 1) {
				deltas[endIndices[i] + 1] -= additions[i];
			}
		}

		long[] result = new long[length];
		long offset = 0;
		for (int i = 0; i < result.length; i++) {
			offset += deltas[i];
			result[i] = initial[i] + offset;
		}

		return result;
	}
}
