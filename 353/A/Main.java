import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		System.out.println(solve(x, y));

		sc.close();
	}

	static int solve(int[] x, int[] y) {
		if ((Arrays.stream(x).sum() + Arrays.stream(y).sum()) % 2 != 0) {
			return -1;
		} else if (Arrays.stream(x).sum() % 2 == 0) {
			return 0;
		} else if (IntStream.range(0, x.length).anyMatch(i -> (x[i] + y[i]) % 2 != 0)) {
			return 1;
		} else {
			return -1;
		}
	}
}
