import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			int x = sc.nextInt();
			int[] d = new int[n];
			int[] h = new int[n];
			for (int i = 0; i < n; i++) {
				d[i] = sc.nextInt();
				h[i] = sc.nextInt();
			}

			System.out.println(solve(d, h, x));
		}

		sc.close();
	}

	static int solve(int[] d, int[] h, int x) {
		int maxD = Arrays.stream(d).max().getAsInt();
		if (x <= maxD) {
			return 1;
		}

		int maxDecrease = IntStream.range(0, d.length).map(i -> d[i] - h[i]).max().getAsInt();
		if (maxDecrease <= 0) {
			return -1;
		}

		return divideToCeil(x - maxD, maxDecrease) + 1;
	}

	static int divideToCeil(int x, int y) {
		return x / y + (x % y == 0 ? 0 : 1);
	}
}
