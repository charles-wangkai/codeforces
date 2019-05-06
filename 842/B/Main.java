import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int radius = sc.nextInt();
		int d = sc.nextInt();
		int n = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		int[] r = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
			r[i] = sc.nextInt();
		}
		System.out.println(solve(radius, d, x, y, r));

		sc.close();
	}

	static int solve(int radius, int d, int[] x, int[] y, int[] r) {
		return (int) IntStream.range(0, x.length).filter(i -> square(x[i]) + square(y[i]) >= square(radius - d + r[i])
				&& r[i] <= radius && square(x[i]) + square(y[i]) <= square(radius - r[i])).count();
	}

	static int square(int p) {
		return p * p;
	}
}
