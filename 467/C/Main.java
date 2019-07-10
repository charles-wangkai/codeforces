import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = sc.nextInt();
		}
		System.out.println(solve(p, m, k));

		sc.close();
	}

	static long solve(int[] p, int m, int k) {
		int n = p.length;

		long[][] maxSums = new long[n + 1][k + 1];
		IntStream.range(0, maxSums.length).forEach(i -> Arrays.fill(maxSums[i], -1));
		maxSums[0][0] = 0;

		long lastMSum = 0;
		for (int i = 1; i <= n; i++) {
			lastMSum += p[i - 1];
			if (i > m) {
				lastMSum -= p[i - 1 - m];
			}

			for (int j = 0; j <= k; j++) {
				maxSums[i][j] = maxSums[i - 1][j];

				if (i >= m && j >= 1 && maxSums[i - m][j - 1] != -1) {
					maxSums[i][j] = Math.max(maxSums[i][j], maxSums[i - m][j - 1] + lastMSum);
				}
			}
		}

		return maxSums[n][k];
	}
}
