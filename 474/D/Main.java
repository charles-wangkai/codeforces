import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	static final int MOD_DIVISOR = 1_000_000_007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[t];
		int[] b = new int[t];
		for (int i = 0; i < t; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		System.out.print(solve(a, b, k));

		sc.close();
	}

	static String solve(int[] a, int[] b, int k) {
		int[] wayNums = new int[Arrays.stream(b).max().getAsInt() + 1];
		wayNums[0] = 1;
		for (int i = 0; i < wayNums.length; i++) {
			for (int offset : new int[] { 1, k }) {
				if (i + offset < wayNums.length) {
					wayNums[i + offset] = addMod(wayNums[i + offset], wayNums[i]);
				}
			}
		}

		int[] prefixSums = new int[wayNums.length];
		int prefixSum = 0;
		for (int i = 0; i < prefixSums.length; i++) {
			prefixSum = addMod(prefixSum, wayNums[i]);
			prefixSums[i] = prefixSum;
		}

		return String.join("\n",
				IntStream.range(0, a.length)
						.mapToObj(i -> String.valueOf(subtractMod(prefixSums[b[i]], prefixSums[a[i] - 1])))
						.toArray(String[]::new));
	}

	static int addMod(int x, int y) {
		return (x + y) % MOD_DIVISOR;
	}

	static int subtractMod(int x, int y) {
		return (x - y + MOD_DIVISOR) % MOD_DIVISOR;
	}
}
