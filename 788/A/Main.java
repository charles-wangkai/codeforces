import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a));

		sc.close();
	}

	static long solve(int[] a) {
		int[] diffs = IntStream.range(0, a.length - 1).map(i -> Math.abs(a[i] - a[i + 1])).toArray();

		return Math.max(computeSubArrayMaxSum(negate(diffs, 0)), computeSubArrayMaxSum(negate(diffs, 1)));
	}

	static int[] negate(int[] diffs, int beginIndex) {
		return IntStream.range(0, diffs.length).map(i -> diffs[i] * (i % 2 == beginIndex ? -1 : 1)).toArray();
	}

	static long computeSubArrayMaxSum(int[] p) {
		long result = 0;
		long sum = 0;
		for (int pi : p) {
			sum = Math.max(0, sum + pi);
			result = Math.max(result, sum);
		}

		return result;
	}
}
