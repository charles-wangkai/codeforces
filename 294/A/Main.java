import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		int[] x = new int[m];
		int[] y = new int[m];
		for (int i = 0; i < m; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		Arrays.stream(solve(a, x, y)).forEach(System.out::println);

		sc.close();
	}

	static int[] solve(int[] a, int[] x, int[] y) {
		for (int i = 0; i < x.length; i++) {
			if (x[i] >= 2) {
				a[x[i] - 2] += y[i] - 1;
			}
			if (x[i] < a.length) {
				a[x[i]] += a[x[i] - 1] - y[i];
			}

			a[x[i] - 1] = 0;
		}
		return a;
	}
}
