import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] x = new int[k];
			for (int i = 0; i < x.length; i++) {
				x[i] = sc.nextInt();
			}

			System.out.println(solve(n, x));
		}

		sc.close();
	}

	static int solve(int n, int[] x) {
		return 1 + IntStream.concat(IntStream.of(x[0] - 1, n - x[x.length - 1]),
				IntStream.range(0, x.length - 1).map(i -> (x[i + 1] - x[i]) / 2)).max().getAsInt();
	}
}
