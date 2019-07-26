import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int height = sc.nextInt();
		int[] a = readArray(sc, m);
		int[] b = readArray(sc, n);
		int[][] h = new int[n][];
		for (int i = 0; i < h.length; i++) {
			h[i] = readArray(sc, m);
		}
		System.out.print(solve(h, a, b, height));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}
		return result;
	}

	static String solve(int[][] h, int[] a, int[] b, int height) {
		int n = h.length;
		int m = h[0].length;

		int[][] heights = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				heights[i][j] = (h[i][j] == 0) ? 0 : Math.min(a[j], b[i]);
			}
		}

		return Arrays.stream(heights)
				.map(row -> Arrays.stream(row).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
				.collect(Collectors.joining("\n"));
	}
}
