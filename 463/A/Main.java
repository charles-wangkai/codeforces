import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int s = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		System.out.println(solve(s, x, y));

		sc.close();
	}

	static int solve(int s, int[] x, int[] y) {
		return IntStream.range(0, x.length).filter(i -> s * 100 >= x[i] * 100 + y[i]).map(i -> (100 - y[i]) % 100).max()
				.orElse(-1);
	}
}
