import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			int[] l = new int[n];
			int[] r = new int[n];
			for (int i = 0; i < n; i++) {
				l[i] = sc.nextInt();
				r[i] = sc.nextInt();
			}

			System.out.println(solve(l, r));
		}

		sc.close();
	}

	static int solve(int[] l, int[] r) {
		return Math.max(0, Arrays.stream(l).max().getAsInt() - Arrays.stream(r).min().getAsInt());
	}
}
