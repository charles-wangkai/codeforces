import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] a = new int[n][];
		for (int i = 0; i < a.length; i++) {
			int k = sc.nextInt();
			a[i] = new int[k];
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		System.out.println(solve(a, m));

		sc.close();
	}

	static int solve(int[][] a, int m) {
		boolean[] used = new boolean[m + 1];
		int[] parents = new int[m + 1];
		int result = 0;
		for (int[] ai : a) {
			if (ai.length == 0) {
				result++;
			} else {
				for (int j = 0; j < ai.length; j++) {
					used[ai[j]] = true;

					if (j + 1 < ai.length) {
						int root1 = findRoot(parents, ai[j]);
						int root2 = findRoot(parents, ai[j + 1]);

						if (root1 != root2) {
							parents[root2] = root1;
						}
					}
				}
			}
		}

		Set<Integer> roots = new HashSet<>();
		for (int i = 1; i <= m; i++) {
			if (used[i]) {
				roots.add(findRoot(parents, i));
			}
		}
		result += Math.max(0, roots.size() - 1);

		return result;
	}

	static int findRoot(int[] parents, int node) {
		int root = node;
		while (parents[root] != 0) {
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
