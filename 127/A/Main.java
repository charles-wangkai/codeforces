import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		System.out.println(solve(x, y, k));

		sc.close();
	}

	static double solve(int[] x, int[] y, int k) {
		return IntStream.range(0, x.length - 1)
				.mapToDouble(i -> Math.sqrt(square(x[i + 1] - x[i]) + square(y[i + 1] - y[i]))).sum() * k / 50;
	}

	static int square(int x) {
		return x * x;
	}
}
