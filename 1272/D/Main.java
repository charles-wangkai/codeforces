import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; ++i) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a));

		sc.close();
	}

	static int solve(int[] a) {
		int n = a.length;

		int[] leftLengths = new int[n];
		leftLengths[0] = 1;
		for (int i = 1; i < leftLengths.length; ++i) {
			if (a[i] > a[i - 1]) {
				leftLengths[i] = leftLengths[i - 1] + 1;
			} else {
				leftLengths[i] = 1;
			}
		}

		int[] rightLengths = new int[n];
		rightLengths[rightLengths.length - 1] = 1;
		for (int i = rightLengths.length - 2; i >= 0; --i) {
			if (a[i] < a[i + 1]) {
				rightLengths[i] = rightLengths[i + 1] + 1;
			} else {
				rightLengths[i] = 1;
			}
		}

		return Math.max(Arrays.stream(leftLengths).max().getAsInt(),
				IntStream.rangeClosed(1, n - 2).filter(i -> a[i - 1] < a[i + 1])
						.map(i -> leftLengths[i - 1] + rightLengths[i + 1]).max().orElse(Integer.MIN_VALUE));
	}
}
