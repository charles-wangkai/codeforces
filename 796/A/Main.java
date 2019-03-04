import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, m, k));

		sc.close();
	}

	static int solve(int[] a, int m, int k) {
		return IntStream.range(0, a.length).filter(i -> a[i] != 0 && a[i] <= k).map(i -> Math.abs(i - (m - 1))).min()
				.getAsInt() * 10;
	}
}
