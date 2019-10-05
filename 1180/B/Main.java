import java.util.Scanner;
import java.util.stream.Collectors;
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

	static String solve(int[] a) {
		int nonNegativeIndex = findNonNegativeIndex(a);

		return IntStream.range(0, a.length).mapToObj(
				i -> String.valueOf((i == nonNegativeIndex) ? Math.max(a[i], -1 - a[i]) : Math.min(a[i], -1 - a[i])))
				.collect(Collectors.joining(" "));
	}

	static int findNonNegativeIndex(int[] a) {
		if (a.length % 2 == 0) {
			return -1;
		}

		int maxNonNegative = -1;
		int indexWithMaxNonNegative = -1;
		for (int i = 0; i < a.length; i++) {
			int nonNegative = Math.max(a[i], -1 - a[i]);
			if (nonNegative > maxNonNegative) {
				maxNonNegative = nonNegative;
				indexWithMaxNonNegative = i;
			}
		}

		return indexWithMaxNonNegative;
	}
}
