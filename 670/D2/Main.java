import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = readArray(sc, n);
		int[] b = readArray(sc, n);
		System.out.println(solve(a, b, k));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}

		return result;
	}

	static int solve(int[] a, int[] b, int k) {
		int result = -1;
		int lower = 0;
		int upper = IntStream.range(0, a.length).map(i -> (b[i] + k) / a[i]).max().getAsInt();
		while (lower <= upper) {
			int middle = lower + (upper - lower) / 2;

			if (check(a, b, middle, k)) {
				result = middle;

				lower = middle + 1;
			} else {
				upper = middle - 1;
			}
		}

		return result;
	}

	static boolean check(int[] a, int[] b, int cookieNum, int k) {
		long needed = 0;
		for (int i = 0; i < a.length; ++i) {
			needed += Math.max(0, (long) a[i] * cookieNum - b[i]);

			if (needed > k) {
				return false;
			}
		}

		return true;
	}
}
