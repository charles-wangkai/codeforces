import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; ++tc) {
			int n = sc.nextInt();
			int p = sc.nextInt();
			sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < a.length; ++i) {
				a[i] = sc.nextInt();
			}

			System.out.println(solve(a, p));
		}

		sc.close();
	}

	static int solve(int[] a, int p) {
		int[] sorted = Arrays.stream(a).boxed().sorted().mapToInt(x -> x).toArray();
		int[] minCosts = new int[sorted.length];
		for (int i = 0; i < minCosts.length; ++i) {
			minCosts[i] = sorted[i] + ((i >= 2) ? minCosts[i - 2] : 0);
		}

		for (int i = minCosts.length - 1; i >= 0; --i) {
			if (minCosts[i] <= p) {
				return i + 1;
			}
		}

		return 0;
	}
}
