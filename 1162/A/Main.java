import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int h = sc.nextInt();
		int m = sc.nextInt();
		int[] l = new int[m];
		int[] r = new int[m];
		int[] x = new int[m];
		for (int i = 0; i < m; i++) {
			l[i] = sc.nextInt();
			r[i] = sc.nextInt();
			x[i] = sc.nextInt();
		}
		System.out.println(solve(n, h, l, r, x));

		sc.close();
	}

	static int solve(int n, int h, int[] l, int[] r, int[] x) {
		int[] heights = IntStream.range(0, n).map(i -> h).toArray();
		for (int i = 0; i < l.length; i++) {
			for (int j = l[i] - 1; j <= r[i] - 1; j++) {
				heights[j] = Math.min(heights[j], x[i]);
			}
		}

		return Arrays.stream(heights).map(height -> height * height).sum();
	}
}
