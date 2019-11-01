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

	static String solve(int[] a) {
		int n = a.length;

		long[] negNums = new long[n + 1];
		long[] posNums = new long[n + 1];
		for (int i = 1; i <= n; i++) {
			if (a[i - 1] < 0) {
				negNums[i] = posNums[i - 1] + 1;
				posNums[i] = negNums[i - 1];
			} else {
				negNums[i] = negNums[i - 1];
				posNums[i] = posNums[i - 1] + 1;
			}
		}

		return String.format("%d %d", Arrays.stream(negNums).sum(), Arrays.stream(posNums).sum());
	}
}
