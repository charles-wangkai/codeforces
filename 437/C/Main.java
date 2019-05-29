import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] v = new int[n];
		for (int i = 0; i < v.length; i++) {
			v[i] = sc.nextInt();
		}
		int[] x = new int[m];
		int[] y = new int[m];
		for (int i = 0; i < m; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		System.out.println(solve(v, x, y));

		sc.close();
	}

	static int solve(int[] v, int[] x, int[] y) {
		return IntStream.range(0, x.length).map(i -> Integer.min(v[x[i] - 1], v[y[i] - 1])).sum();
	}
}
