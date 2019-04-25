import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = readArray(sc, n);
		int[] b = readArray(sc, m);
		System.out.println(Arrays.stream(solve(a, b)).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}

	static int[] solve(int[] a, int[] b) {
		int[] sortedA = Arrays.stream(a).boxed().sorted().mapToInt(x -> x).toArray();

		return Arrays.stream(b).map(target -> findLessEqualCount(sortedA, target)).toArray();
	}

	static int findLessEqualCount(int[] sortedA, int target) {
		int lowerIndex = 0;
		int upperIndex = sortedA.length - 1;
		int resultIndex = -1;
		while (lowerIndex <= upperIndex) {
			int middleIndex = (lowerIndex + upperIndex) / 2;

			if (sortedA[middleIndex] <= target) {
				resultIndex = middleIndex;
				lowerIndex = middleIndex + 1;
			} else {
				upperIndex = middleIndex - 1;
			}
		}
		return resultIndex + 1;
	}
}
