import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] groups = new int[m][];
		for (int i = 0; i < groups.length; i++) {
			int k = sc.nextInt();
			groups[i] = new int[k];
			for (int j = 0; j < groups[i].length; j++) {
				groups[i][j] = sc.nextInt() - 1;
			}
		}
		System.out.print(solve(n, groups));

		sc.close();
	}

	static String solve(int n, int[][] groups) {
		int[] parents = new int[n];
		Arrays.fill(parents, -1);

		for (int[] group : groups) {
			for (int i = 0; i < group.length - 1; i++) {
				int root1 = findRoot(parents, group[i]);
				int root2 = findRoot(parents, group[i + 1]);

				if (root1 != root2) {
					parents[root2] = root1;
				}
			}
		}

		Map<Integer, Integer> rootToSize = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int root = findRoot(parents, i);

			rootToSize.put(root, rootToSize.getOrDefault(root, 0) + 1);
		}

		return IntStream.range(0, n).mapToObj(i -> String.valueOf(rootToSize.get(findRoot(parents, i))))
				.collect(Collectors.joining(" "));
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
