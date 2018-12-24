import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int l = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a, l));

		sc.close();
	}

	static double solve(int[] a, int l) {
		Arrays.sort(a);

		return DoubleStream.concat(Arrays.stream(new double[] { a[0], l - a[a.length - 1] }),
				IntStream.range(0, a.length - 1).mapToDouble(i -> (a[i + 1] - a[i]) / 2.0)).max().getAsDouble();
	}
}
