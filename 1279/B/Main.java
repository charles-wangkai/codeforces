import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; ++tc) {
			int n = sc.nextInt();
			int s = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < a.length; ++i) {
				a[i] = sc.nextInt();
			}

			System.out.println(solve(a, s));
		}

		sc.close();
	}

	static int solve(int[] a, int s) {
		int n = a.length;

		int leftMaxIndex = -1;
		int[] leftMaxIndices = new int[n];
		for (int i = 0; i < leftMaxIndices.length; ++i) {
			if (leftMaxIndex == -1 || a[i] > a[leftMaxIndex]) {
				leftMaxIndex = i;
			}

			leftMaxIndices[i] = leftMaxIndex;
		}

		long prefixSum = 0;
		long[] prefixSums = new long[n];
		for (int i = 0; i < prefixSums.length; ++i) {
			prefixSum += a[i];
			prefixSums[i] = prefixSum;
		}

		for (int i = n - 1;; --i) {
			if (prefixSums[i] <= s) {
				return 0;
			}

			if (prefixSums[i] - a[leftMaxIndices[i]] <= s) {
				return leftMaxIndices[i] + 1;
			}
		}
	}
}
