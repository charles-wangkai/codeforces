import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = readArray(sc, n);
		int[] t = readArray(sc, n);
		System.out.println(solve(a, t, k));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}

	static int solve(int[] a, int[] t, int k) {
		int n = a.length;

		int[] leftSums = new int[n];
		int leftSum = 0;
		for (int i = 0; i < n; i++) {
			leftSum += a[i] * t[i];
			leftSums[i] = leftSum;
		}

		int[] rightSums = new int[n];
		int rightSum = 0;
		for (int i = n - 1; i >= 0; i--) {
			rightSum += a[i] * t[i];
			rightSums[i] = rightSum;
		}

		int[] leftAwakenSums = new int[n];
		int leftAwakenSum = 0;
		for (int i = 0; i < n; i++) {
			leftAwakenSum += a[i];
			leftAwakenSums[i] = leftAwakenSum;
		}

		return IntStream.rangeClosed(0, n - k)
				.map(i -> ((i == 0) ? 0 : leftSums[i - 1]) + ((i + k == n) ? 0 : rightSums[i + k])
						+ (leftAwakenSums[i + k - 1] - ((i == 0) ? 0 : leftAwakenSums[i - 1])))
				.max().getAsInt();
	}
}
