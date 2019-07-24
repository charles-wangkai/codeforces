import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int F = sc.nextInt();
		int V = sc.nextInt();
		int[][] A = new int[F][V];
		for (int i = 0; i < F; i++) {
			for (int j = 0; j < V; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		System.out.print(solve(A));

		sc.close();
	}

	static String solve(int[][] A) {
		int F = A.length;
		int V = A[0].length;

		int[][] maxSums = new int[F + 1][V + 1];
		for (int i = 0; i < maxSums.length; i++) {
			Arrays.fill(maxSums[i], Integer.MIN_VALUE);
		}
		maxSums[0][0] = 0;

		for (int i = 1; i <= F; i++) {
			int prevMaxSum = maxSums[i - 1][0];
			for (int j = 1; j <= V; j++) {
				if (prevMaxSum != Integer.MIN_VALUE) {
					maxSums[i][j] = prevMaxSum + A[i - 1][j - 1];
				}

				prevMaxSum = Math.max(prevMaxSum, maxSums[i - 1][j]);
			}
		}

		int overallMaxSum = Arrays.stream(maxSums[F]).max().getAsInt();

		int[] vaseIds = new int[F];
		int maxSum = overallMaxSum;
		int j = V;
		for (int i = vaseIds.length - 1; i >= 0; i--) {
			while (maxSums[i + 1][j] != maxSum) {
				j--;
			}

			vaseIds[i] = j;

			maxSum -= A[i][j - 1];
			j--;
		}

		return String.format("%d\n%s", overallMaxSum,
				Arrays.stream(vaseIds).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
	}
}
