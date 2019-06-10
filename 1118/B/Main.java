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

	static int solve(int[] a) {
		int[] leftEvenSums = new int[a.length];
		int[] leftOddSums = new int[a.length];
		int leftEvenSum = 0;
		int leftOddSum = 0;
		for (int i = 0; i < a.length; i++) {
			leftEvenSums[i] = leftEvenSum;
			leftOddSums[i] = leftOddSum;

			if (i % 2 == 0) {
				leftEvenSum += a[i];
			} else {
				leftOddSum += a[i];
			}
		}

		int[] rightEvenSums = new int[a.length];
		int[] rightOddSums = new int[a.length];
		int rightEvenSum = 0;
		int rightOddSum = 0;
		for (int i = a.length - 1; i >= 0; i--) {
			rightEvenSums[i] = rightEvenSum;
			rightOddSums[i] = rightOddSum;

			if (i % 2 == 0) {
				rightEvenSum += a[i];
			} else {
				rightOddSum += a[i];
			}
		}

		return (int) IntStream.range(0, a.length)
				.filter(i -> leftEvenSums[i] + rightOddSums[i] == leftOddSums[i] + rightEvenSums[i]).count();
	}
}
