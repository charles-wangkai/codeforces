import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[][] a = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		int[] x = new int[n];
		for (int i = 0; i < x.length; i++) {
			x[i] = sc.nextInt();
		}
		System.out.println(solve(a, x));

		sc.close();
	}

	static String solve(int[][] a, int[] x) {
		int n = x.length;

		int[][] distances = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				distances[i][j] = (i == j) ? 0 : Integer.MAX_VALUE;
			}
		}

		long[] result = new long[n];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i + 1; j < n; j++) {
				for (int k = i + 1; k < n; k++) {
					distances[x[j]][x[i]] = Math.min(distances[x[j]][x[i]], distances[x[j]][x[k]] + a[x[k]][x[i]]);
					distances[x[i]][x[j]] = Math.min(distances[x[i]][x[j]], a[x[i]][x[k]] + distances[x[k]][x[j]]);
				}
			}

			for (int j = i + 1; j < n; j++) {
				for (int k = i + 1; k < n; k++) {
					distances[x[j]][x[k]] = Math.min(distances[x[j]][x[k]],
							distances[x[j]][x[i]] + distances[x[i]][x[k]]);
				}
			}

			for (int j = i; j < n; j++) {
				for (int k = i; k < n; k++) {
					result[i] += distances[x[j]][x[k]];
				}
			}
		}

		return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
	}
}
