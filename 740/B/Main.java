import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		int[] l = new int[m];
		int[] r = new int[m];
		for (int i = 0; i < m; i++) {
			l[i] = sc.nextInt();
			r[i] = sc.nextInt();
		}
		System.out.println(solve(a, l, r));

		sc.close();
	}

	static int solve(int[] a, int[] l, int[] r) {
		return IntStream.range(0, l.length).map(i -> Math.max(0, IntStream.range(l[i] - 1, r[i]).map(j -> a[j]).sum()))
				.sum();
	}
}
