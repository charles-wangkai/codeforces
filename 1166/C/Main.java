import java.util.Arrays;
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
		int[] sorted = Arrays.stream(a).map(Math::abs).boxed().sorted().mapToInt(x -> x).toArray();

		return IntStream.range(0, sorted.length).map(i -> findMaxIndexWithLessEqual(sorted, sorted[i] * 2) - i)
				.asLongStream().sum();
	}

	static int findMaxIndexWithLessEqual(int[] sorted, int target) {
		int result = -1;
		int lowerIndex = 0;
		int upperIndex = sorted.length - 1;
		while (lowerIndex <= upperIndex) {
			int middleIndex = (lowerIndex + upperIndex) / 2;
			if (sorted[middleIndex] <= target) {
				result = middleIndex;
				lowerIndex = middleIndex + 1;
			} else {
				upperIndex = middleIndex - 1;
			}
		}

		return result;
	}
}
