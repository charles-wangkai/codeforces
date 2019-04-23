import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.stream(solve(a, k)).forEach(System.out::println);

		sc.close();
	}

	static int[] solve(int[] a, int k) {
		int[] sortedDistincts = Arrays.stream(a).distinct().sorted().toArray();

		int[] result = new int[k];
		for (int i = 0; i < result.length; i++) {
			if (i == 0) {
				result[i] = sortedDistincts[0];
			} else if (i < sortedDistincts.length) {
				result[i] = sortedDistincts[i] - sortedDistincts[i - 1];
			} else {
				result[i] = 0;
			}
		}
		return result;
	}
}
