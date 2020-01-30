import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] t = new int[n];
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; ++i) {
			t[i] = sc.nextInt();
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		System.out.println(solve(t, x, y));

		sc.close();
	}

	static String solve(int[] t, int[] x, int[] y) {
		int[] xTotals = new int[3];
		int[] yTotals = new int[3];
		for (int i = 0; i < t.length; ++i) {
			xTotals[t[i]] += x[i];
			yTotals[t[i]] += y[i];
		}

		return IntStream.rangeClosed(1, 2).mapToObj(i -> (xTotals[i] >= yTotals[i]) ? "LIVE" : "DEAD")
				.collect(Collectors.joining("\n"));
	}
}
