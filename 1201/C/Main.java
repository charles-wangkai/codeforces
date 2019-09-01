import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, k));

		sc.close();
	}

	static int solve(int[] a, int k) {
		a = Arrays.stream(a).boxed().sorted().mapToInt(x -> x).toArray();

		int medianIndex = a.length / 2;
		int result = 0;
		int lower = a[medianIndex];
		int upper = a[medianIndex] + k;
		while (lower <= upper) {
			int middle = lower + (upper - lower) / 2;

			if (computeOperationNum(a, medianIndex, middle) <= k) {
				result = middle;

				lower = middle + 1;
			} else {
				upper = middle - 1;
			}
		}

		return result;
	}

	static long computeOperationNum(int[] a, int medianIndex, int median) {
		return IntStream.range(medianIndex, a.length).mapToLong(i -> Math.max(0, median - a[i])).sum();
	}
}
