// https://www.geeksforgeeks.org/tarjan-algorithm-find-strongly-connected-components/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

public class Main {
	static final int MODULUS = 1_000_000_007;

	static int time;
	static long costSum;
	static int wayNum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] costs = new int[n];
		for (int i = 0; i < costs.length; i++) {
			costs[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		int[] u = new int[m];
		int[] v = new int[m];
		for (int i = 0; i < m; i++) {
			u[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		System.out.println(solve(costs, u, v));

		sc.close();
	}

	static String solve(int[] costs, int[] u, int[] v) {
		int n = costs.length;

		@SuppressWarnings("unchecked")
		List<Integer>[] adjLists = new List[n];
		for (int i = 0; i < adjLists.length; i++) {
			adjLists[i] = new ArrayList<>();
		}

		for (int i = 0; i < u.length; i++) {
			adjLists[u[i] - 1].add(v[i] - 1);
		}

		time = 0;
		costSum = 0;
		wayNum = 1;
		int[] times = IntStream.range(0, n).map(i -> -1).toArray();
		int[] lows = IntStream.range(0, n).map(i -> -1).toArray();
		Stack<Integer> stack = new Stack<>();
		boolean[] stackMembers = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (times[i] == -1) {
				search(costs, adjLists, times, lows, stack, stackMembers, i);
			}
		}

		return String.format("%d %d", costSum, wayNum);
	}

	static void search(int[] costs, List<Integer>[] adjLists, int[] times, int[] lows, Stack<Integer> stack,
			boolean[] stackMembers, int node) {
		times[node] = time;
		lows[node] = time;
		time++;

		stack.push(node);
		stackMembers[node] = true;

		for (int adj : adjLists[node]) {
			if (times[adj] == -1) {
				search(costs, adjLists, times, lows, stack, stackMembers, adj);

				lows[node] = Math.min(lows[node], lows[adj]);
			} else if (stackMembers[adj]) {
				lows[node] = Math.min(lows[node], times[adj]);
			}
		}

		if (lows[node] == times[node]) {
			List<Integer> sccCosts = new ArrayList<>();
			while (true) {
				int p = stack.pop();
				stackMembers[p] = false;
				sccCosts.add(costs[p]);

				if (p == node) {
					break;
				}
			}

			int minSccCost = sccCosts.stream().mapToInt(x -> x).min().getAsInt();
			costSum += minSccCost;

			wayNum = multiplyMod(wayNum, (int) sccCosts.stream().filter(sccCost -> sccCost == minSccCost).count());
		}
	}

	static int multiplyMod(int x, int y) {
		return (int) ((long) x * y % MODULUS);
	}
}
