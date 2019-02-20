import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		System.out.println(solve(a, b, m));

		sc.close();
	}

	static double solve(int[] a, int[] b, int m) {
		return IntStream.range(0, a.length).mapToDouble(i -> (double) a[i] / b[i]).min().getAsDouble() * m;
	}
}
