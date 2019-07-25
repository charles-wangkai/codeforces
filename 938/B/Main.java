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
		return IntStream.rangeClosed(0, a.length)
				.map(leftNum -> Math.max(computeLeftTime(a, leftNum), computeRightTime(a, leftNum))).min().getAsInt();
	}

	static int computeLeftTime(int[] a, int leftNum) {
		if (leftNum == 0) {
			return 0;
		}

		return a[leftNum - 1] - 1;
	}

	static int computeRightTime(int[] a, int leftNum) {
		if (leftNum == a.length) {
			return 0;
		}

		return 1_000_000 - a[leftNum];
	}
}
