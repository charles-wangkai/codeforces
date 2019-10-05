import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] p = new int[n];
		for (int i = 0; i < p.length; i++) {
			p[i] = sc.nextInt();
		}
		System.out.println(solve(p));

		sc.close();
	}

	static int solve(int[] p) {
		int[] parents = new int[p.length];
		Arrays.fill(parents, -1);

		for (int i = 0; i < p.length; i++) {
			int root1 = findRoot(parents, i);
			int root2 = findRoot(parents, p[i] - 1);

			if (root1 != root2) {
				parents[root2] = root1;
			}
		}

		return (int) Arrays.stream(parents).filter(parent -> parent == -1).count();
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
