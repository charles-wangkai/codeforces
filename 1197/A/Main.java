import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = sc.nextInt();
			}

			System.out.println(solve(a));
		}

		sc.close();
	}

	static int solve(int[] a) {
		int[] sorted = Arrays.stream(a).boxed().sorted().mapToInt(x -> x).toArray();

		return Math.min(sorted[sorted.length - 2] - 1, sorted.length - 2);
	}
}
