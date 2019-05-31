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

	static int solve(int[] a) {
		int[] leftLengths = buildLeftLengths(a);
		int[] rightLengths = buildRightLengths(a);

		int result = Arrays.stream(leftLengths).max().getAsInt();
		for (int i = 0; i < a.length; i++) {
			int leftValue;
			int leftLength;
			if (i == 0) {
				leftValue = Integer.MIN_VALUE;
				leftLength = 0;
			} else {
				leftValue = a[i - 1];
				leftLength = leftLengths[i - 1];
			}

			int rightValue;
			int rightLength;
			if (i == a.length - 1) {
				rightValue = Integer.MAX_VALUE;
				rightLength = 0;
			} else {
				rightValue = a[i + 1];
				rightLength = rightLengths[i + 1];
			}

			if (leftValue + 1 < rightValue) {
				result = Math.max(result, leftLength + rightLength + 1);
			} else {
				result = Math.max(result, Math.max(leftLength, rightLength) + 1);
			}
		}
		return result;
	}

	static int[] buildLeftLengths(int[] a) {
		int[] leftLengths = new int[a.length];
		int leftLength = -1;
		for (int i = 0; i < leftLengths.length; i++) {
			if (i != 0 && a[i] > a[i - 1]) {
				leftLength++;
			} else {
				leftLength = 1;
			}

			leftLengths[i] = leftLength;
		}
		return leftLengths;
	}

	static int[] buildRightLengths(int[] a) {
		int[] rightLengths = new int[a.length];
		int rightLength = -1;
		for (int i = rightLengths.length - 1; i >= 0; i--) {
			if (i != rightLengths.length - 1 && a[i] < a[i + 1]) {
				rightLength++;
			} else {
				rightLength = 1;
			}

			rightLengths[i] = rightLength;
		}
		return rightLengths;
	}
}
