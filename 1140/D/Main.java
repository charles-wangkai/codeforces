import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		System.out.println(solve(n));

		sc.close();
	}

	static long solve(int n) {
		long[][] minWeights = new long[n - 1][n];
		for (int i = 0; i < minWeights.length; i++) {
			Arrays.fill(minWeights[i], Long.MAX_VALUE);
		}

		for (int i = 0; i < minWeights.length; i++) {
			minWeights[i][i + 1] = 0;
		}

		for (int diff = 2; diff <= n - 1; diff++) {
			for (int i = 0; i + diff < n; i++) {
				int j = i + diff;

				for (int k = i + 1; k < j; k++) {
					minWeights[i][j] = Math.min(minWeights[i][j],
							minWeights[i][k] + minWeights[k][j] + (i + 1) * (k + 1) * (j + 1));
				}
			}
		}

		return minWeights[0][n - 1];
	}
}
