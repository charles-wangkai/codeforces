import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out
				.println(String.join(" ", Arrays.stream(solve(a, m)).mapToObj(String::valueOf).toArray(String[]::new)));

		sc.close();
	}

	static long[] solve(int[] a, int m) {
		long sum = 0;
		long resultPrevSum = 0;
		long[] result = new long[a.length];
		for (int i = 0; i < result.length; i++) {
			sum += a[i];

			result[i] = sum / m - resultPrevSum;
			resultPrevSum += result[i];
		}
		return result;
	}
}
