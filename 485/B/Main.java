import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; ++i) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		System.out.println(solve(x, y));

		sc.close();
	}

	static long solve(int[] x, int[] y) {
		int maxSide = Math.max(Arrays.stream(x).max().getAsInt() - Arrays.stream(x).min().getAsInt(),
				Arrays.stream(y).max().getAsInt() - Arrays.stream(y).min().getAsInt());

		return (long) maxSide * maxSide;
	}
}
