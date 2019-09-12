import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] u = new int[n - 1];
		int[] v = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			u[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		int[] c = new int[n + 1];
		for (int i = 1; i < c.length; i++) {
			c[i] = sc.nextInt();
		}
		System.out.print(solve(u, v, c));

		sc.close();
	}

	static String solve(int[] u, int[] v, int[] c) {
		int n = u.length + 1;

		@SuppressWarnings("unchecked")
		List<Integer>[] adjLists = new List[n + 1];
		for (int i = 1; i < adjLists.length; i++) {
			adjLists[i] = new ArrayList<>();
		}
		for (int i = 0; i < n - 1; i++) {
			adjLists[u[i]].add(v[i]);
			adjLists[v[i]].add(u[i]);
		}

		for (int i = 0; i < n - 1; i++) {
			if (c[u[i]] != c[v[i]]) {
				if (isValidRoot(adjLists, c, u[i])) {
					return String.format("YES\n%d", u[i]);
				} else if (isValidRoot(adjLists, c, v[i])) {
					return String.format("YES\n%d", v[i]);
				} else {
					return "NO";
				}
			}
		}

		return "YES\n1";
	}

	static boolean isValidRoot(List<Integer>[] adjLists, int[] c, int root) {
		boolean[] visited = new boolean[c.length];
		visited[root] = true;

		for (int adj : adjLists[root]) {
			if (!search(adjLists, c, visited, c[adj], adj)) {
				return false;
			}
		}

		return true;
	}

	static boolean search(List<Integer>[] adjLists, int[] c, boolean[] visited, int targetColor, int node) {
		if (c[node] != targetColor) {
			return false;
		}

		visited[node] = true;

		for (int adj : adjLists[node]) {
			if (!visited[adj] && !search(adjLists, c, visited, targetColor, adj)) {
				return false;
			}
		}

		return true;
	}
}
