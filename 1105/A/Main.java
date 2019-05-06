import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(a));

		sc.close();
	}

	static String solve(int[] a) {
		int minCost = Integer.MAX_VALUE;
		int bestT = -1;
		for (int t = 1; t <= 100; t++) {
			int cost = computeCost(a, t);

			if (cost < minCost) {
				minCost = cost;
				bestT = t;
			}
		}

		return String.format("%d %d", bestT, minCost);
	}

	static int computeCost(int[] a, int t) {
		return Arrays.stream(a).map(x -> Math.max(0, Math.abs(x - t) - 1)).sum();
	}
}
