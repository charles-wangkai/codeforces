import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int n = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		int[] v = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		System.out.println(solve(a, b, x, y, v));

		sc.close();
	}

	static double solve(int a, int b, int[] x, int[] y, int[] v) {
		return IntStream.range(0, x.length)
				.mapToDouble(i -> Math.sqrt((x[i] - a) * (x[i] - a) + (y[i] - b) * (y[i] - b)) / v[i]).min()
				.getAsDouble();
	}
}
