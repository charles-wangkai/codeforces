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
		int n = a.length;

		if (k == 1) {
			return Arrays.stream(a).min().getAsInt();
		} else if (k >= 3) {
			return Arrays.stream(a).max().getAsInt();
		}

		int[] leftMins = new int[n];
		int leftMin = Integer.MAX_VALUE;
		for (int i = 0; i < leftMins.length; i++) {
			leftMin = Math.min(leftMin, a[i]);
			leftMins[i] = leftMin;
		}

		int[] rightMins = new int[n];
		int rightMin = Integer.MAX_VALUE;
		for (int i = rightMins.length - 1; i >= 0; i--) {
			rightMin = Math.min(rightMin, a[i]);
			rightMins[i] = rightMin;
		}

		return IntStream.rangeClosed(0, n - 2).map(i -> Math.max(leftMins[i], rightMins[i + 1])).max().getAsInt();
	}
}
