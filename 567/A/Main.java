import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] x = new int[n];
		for (int i = 0; i < x.length; i++) {
			x[i] = sc.nextInt();
		}
		System.out.print(solve(x));

		sc.close();
	}

	static String solve(int[] x) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < x.length; i++) {
			int minCost = Integer.MAX_VALUE;
			int maxCost = Integer.MIN_VALUE;

			if (i != 0) {
				minCost = Math.min(minCost, x[i] - x[i - 1]);
				maxCost = Math.max(maxCost, x[i] - x[0]);
			}
			if (i != x.length - 1) {
				minCost = Math.min(minCost, x[i + 1] - x[i]);
				maxCost = Math.max(maxCost, x[x.length - 1] - x[i]);
			}

			result.append(String.format("%d %d", minCost, maxCost)).append("\n");
		}
		return result.toString();
	}
}
