import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] u = new int[m];
		int[] v = new int[m];
		for (int i = 0; i < m; i++) {
			u[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		System.out.println(solve(n, u, v));

		sc.close();
	}

	static int solve(int n, int[] u, int[] v) {
		@SuppressWarnings("unchecked")
		Set<Integer>[] adjSets = new Set[n + 1];
		for (int i = 1; i < adjSets.length; i++) {
			adjSets[i] = new HashSet<>();
		}

		for (int i = 0; i < u.length; i++) {
			adjSets[u[i]].add(v[i]);
			adjSets[v[i]].add(u[i]);
		}

		if (adjSets[1].contains(n)) {
			adjSets = invert(adjSets);
		}

		return findMinDist(adjSets);
	}

	static int findMinDist(Set<Integer>[] adjSets) {
		int n = adjSets.length - 1;

		int[] minDists = new int[n + 1];
		Arrays.fill(minDists, -1);

		Queue<Integer> queue = new LinkedList<>();
		minDists[1] = 0;
		queue.offer(1);
		while (!queue.isEmpty()) {
			int head = queue.poll();

			for (int adj : adjSets[head]) {
				if (minDists[adj] == -1) {
					minDists[adj] = minDists[head] + 1;
					queue.offer(adj);
				}
			}
		}

		return minDists[n];
	}

	static Set<Integer>[] invert(Set<Integer>[] adjSets) {
		int n = adjSets.length - 1;

		@SuppressWarnings("unchecked")
		Set<Integer>[] result = new Set[n + 1];
		for (int i = 1; i < result.length; i++) {
			result[i] = new HashSet<>();
		}

		for (int i = 1; i < result.length; i++) {
			for (int j = 1; j <= n; j++) {
				if (j != i && !adjSets[i].contains(j)) {
					result[i].add(j);
				}
			}
		}

		return result;
	}
}
