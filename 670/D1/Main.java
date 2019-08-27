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
			int middle = (lower + upper) / 2;

			if (computeNeededMagicNum(a, b, middle) <= k) {
				result = middle;

				lower = middle + 1;
			} else {
				upper = middle - 1;
			}
		}

		return result;
	}

	static int computeNeededMagicNum(int[] a, int[] b, int cookieNum) {
		return IntStream.range(0, a.length).map(i -> Math.max(0, a[i] * cookieNum - b[i])).sum();
	}
}
