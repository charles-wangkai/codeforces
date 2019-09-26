import java.util.Arrays;
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
		int[] extended = IntStream.concat(IntStream.concat(IntStream.of(0), Arrays.stream(a)), IntStream.of(1001))
				.toArray();

		int maxCount = 0;
		int count = 1;
		for (int i = 1; i < extended.length; i++) {
			if (extended[i] - extended[i - 1] == 1) {
				count++;
			} else {
				count = 1;
			}

			maxCount = Math.max(maxCount, count);
		}

		return Math.max(0, maxCount - 2);
	}
}
