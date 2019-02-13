import java.util.Arrays;
import java.util.Scanner;

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
		Arrays.sort(a);

		long[] suffixSums = new long[a.length];
		long suffixSum = 0;
		for (int i = suffixSums.length - 1; i >= 0; i--) {
			suffixSum += a[i];
			suffixSums[i] = suffixSum;
		}

		return Arrays.stream(suffixSums).sum() - suffixSums[suffixSums.length - 1] + suffixSums[0];
	}
}
