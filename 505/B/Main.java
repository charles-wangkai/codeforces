import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[m];
		int[] b = new int[m];
		int[] c = new int[m];
		for (int i = 0; i < m; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
			c[i] = sc.nextInt();
		}
		int q = sc.nextInt();
		int[] u = new int[q];
		int[] v = new int[q];
		for (int i = 0; i < q; i++) {
			u[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		System.out.print(solve(n, a, b, c, u, v));

		sc.close();
	}

	static String solve(int n, int[] a, int[] b, int[] c, int[] u, int[] v) {
		int m = a.length;

		int[][] colorToParents = new int[m + 1][n + 1];
		for (int i = 0; i < m; i++) {
			int root1 = findRoot(colorToParents[c[i]], a[i]);
			int root2 = findRoot(colorToParents[c[i]], b[i]);

			if (root1 != root2) {
				colorToParents[c[i]][root2] = root1;
			}
		}

		return IntStream.range(0, u.length)
				.mapToObj(i -> String.valueOf(Arrays.stream(colorToParents)
						.filter(parents -> findRoot(parents, u[i]) == findRoot(parents, v[i])).count()))
				.collect(Collectors.joining("\n"));
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
