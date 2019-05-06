import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int q = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		int[] l = new int[q];
		int[] r = new int[q];
		for (int i = 0; i < q; i++) {
			l[i] = sc.nextInt();
			r[i] = sc.nextInt();
		}
		System.out.println(solve(a, l, r));

		sc.close();
	}

	static long solve(int[] a, int[] l, int[] r) {
		int[] deltas = new int[a.length];
		for (int i = 0; i < l.length; i++) {
			deltas[l[i] - 1]++;

			if (r[i] < deltas.length) {
				deltas[r[i]]--;
			}
		}

		int count = 0;
		int[] counts = new int[a.length];
		for (int i = 0; i < counts.length; i++) {
			count += deltas[i];

			counts[i] = count;
		}

		Arrays.sort(a);
		Arrays.sort(counts);

		return IntStream.range(0, a.length).mapToLong(i -> (long) a[i] * counts[i]).sum();
	}
}
