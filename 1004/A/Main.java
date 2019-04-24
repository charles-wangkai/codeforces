import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int d = sc.nextInt();
		int[] x = new int[n];
		for (int i = 0; i < x.length; i++) {
			x[i] = sc.nextInt();
		}
		System.out.println(solve(x, d));

		sc.close();
	}

	static int solve(int[] x, int d) {
		return IntStream.range(1, x.length).map(i -> Math.min(2, Math.max(0, (x[i] - d) - (x[i - 1] + d) + 1))).sum()
				+ 2;
	}
}
