import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	static final int LIMIT = 200010;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int q = sc.nextInt();
		int[] l = new int[n];
		int[] r = new int[n];
		for (int i = 0; i < n; i++) {
			l[i] = sc.nextInt();
			r[i] = sc.nextInt();
		}
		int[] a = new int[q];
		int[] b = new int[q];
		for (int i = 0; i < q; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		System.out.println(solve(l, r, k, a, b));

		sc.close();
	}

	static String solve(int[] l, int[] r, int k, int[] a, int[] b) {
		int[] deltas = new int[LIMIT];
		for (int i = 0; i < l.length; i++) {
			deltas[l[i]]++;
			deltas[r[i] + 1]--;
		}

		int[] counts = new int[LIMIT];
		int count = 0;
		for (int i = 0; i < counts.length; i++) {
			count += deltas[i];
			counts[i] = count;
		}

		int[] prefixSums = new int[LIMIT];
		int prefixSum = 0;
		for (int i = 0; i < prefixSums.length; i++) {
			if (counts[i] >= k) {
				prefixSum++;
			}

			prefixSums[i] = prefixSum;
		}

		return IntStream.range(0, a.length).mapToObj(i -> String.valueOf(prefixSums[b[i]] - prefixSums[a[i] - 1]))
				.collect(Collectors.joining("\n"));
	}
}
