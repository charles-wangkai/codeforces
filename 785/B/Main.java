import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] l1 = new int[n];
		int[] r1 = new int[n];
		for (int i = 0; i < n; i++) {
			l1[i] = sc.nextInt();
			r1[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		int[] l2 = new int[m];
		int[] r2 = new int[m];
		for (int i = 0; i < m; i++) {
			l2[i] = sc.nextInt();
			r2[i] = sc.nextInt();
		}
		System.out.println(solve(l1, r1, l2, r2));

		sc.close();
	}

	static int solve(int[] l1, int[] r1, int[] l2, int[] r2) {
		return Math.max(Math.max(0, Arrays.stream(l1).max().getAsInt() - Arrays.stream(r2).min().getAsInt()),
				Math.max(0, Arrays.stream(l2).max().getAsInt() - Arrays.stream(r1).min().getAsInt()));
	}
}
