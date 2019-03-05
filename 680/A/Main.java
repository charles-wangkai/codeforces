import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t1 = sc.nextInt();
		int t2 = sc.nextInt();
		int t3 = sc.nextInt();
		int t4 = sc.nextInt();
		int t5 = sc.nextInt();
		System.out.println(solve(t1, t2, t3, t4, t5));

		sc.close();
	}

	static int solve(int t1, int t2, int t3, int t4, int t5) {
		int[] sorted = IntStream.of(t1, t2, t3, t4, t5).sorted().toArray();

		int sum = Arrays.stream(sorted).sum();
		int result = sum;
		for (int i = 0; i < sorted.length; i++) {
			for (int length : new int[] { 2, 3 }) {
				if (i + length - 1 < sorted.length && sorted[i] == sorted[i + length - 1]) {
					result = Math.min(result, sum - sorted[i] * length);
				}
			}
		}
		return result;
	}
}
