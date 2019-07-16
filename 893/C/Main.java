import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] c = new int[n];
		for (int i = 0; i < c.length; i++) {
			c[i] = sc.nextInt();
		}
		int[] x = new int[m];
		int[] y = new int[m];
		for (int i = 0; i < m; i++) {
			x[i] = sc.nextInt() - 1;
			y[i] = sc.nextInt() - 1;
		}
		System.out.println(solve(c, x, y));

		sc.close();
	}

	static long solve(int[] c, int[] x, int[] y) {
		int[] parents = new int[c.length];
		Arrays.fill(parents, -1);

		for (int i = 0; i < x.length; i++) {
			int rootX = findRoot(parents, x[i]);
			int rootY = findRoot(parents, y[i]);

			if (rootX != rootY) {
				if (c[rootX] <= c[rootY]) {
					parents[rootY] = rootX;
				} else {
					parents[rootX] = rootY;
				}
			}
		}

		return IntStream.range(0, c.length).filter(i -> parents[i] == -1).map(i -> c[i]).asLongStream().sum();
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
