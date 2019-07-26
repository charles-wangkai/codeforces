import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[m];
		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		System.out.println(solve(n, a, b) ? "YES" : "NO");

		sc.close();
	}

	static boolean solve(int n, int[] a, int[] b) {
		int[] parents = new int[n];
		Arrays.fill(parents, -1);

		for (int i = 0; i < a.length; i++) {
			int rootA = findRoot(parents, a[i] - 1);
			int rootB = findRoot(parents, b[i] - 1);

			if (rootA != rootB) {
				parents[rootB] = rootA;
			}
		}

		Map<Integer, Integer> rootToNodeCount = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int root = findRoot(parents, i);

			rootToNodeCount.put(root, rootToNodeCount.getOrDefault(root, 0) + 1);
		}

		Map<Integer, Integer> rootToEdgeCount = new HashMap<>();
		for (int ai : a) {
			int root = findRoot(parents, ai - 1);

			rootToEdgeCount.put(root, rootToEdgeCount.getOrDefault(root, 0) + 1);
		}

		return rootToNodeCount.keySet().stream().allMatch(root -> {
			int nodeCount = rootToNodeCount.get(root);

			return nodeCount * (nodeCount - 1L) / 2 == rootToEdgeCount.getOrDefault(root, 0);
		});
	}

	static int findRoot(int[] parents, int node) {
		int root = node;
		while (parents[root] != -1) {
			root = parents[root];
		}

		int p = node;
		while (p != root) {
			int next = parents[p];
			parents[p] = root;

			p = next;
		}

		return root;
	}
}
