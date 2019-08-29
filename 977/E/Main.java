import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] v = new int[m];
		int[] u = new int[m];
		for (int i = 0; i < m; i++) {
			v[i] = sc.nextInt();
			u[i] = sc.nextInt();
		}
		System.out.println(solve(n, v, u));

		sc.close();
	}

	static int solve(int n, int[] v, int[] u) {
		@SuppressWarnings("unchecked")
		List<Integer>[] adjLists = new List[n];
		for (int i = 0; i < adjLists.length; i++) {
			adjLists[i] = new ArrayList<>();
		}

		for (int i = 0; i < v.length; i++) {
			adjLists[v[i] - 1].add(u[i] - 1);
			adjLists[u[i] - 1].add(v[i] - 1);
		}

		int result = 0;
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i] && search(adjLists, visited, i)) {
				result++;
			}
		}

		return result;
	}

	static boolean search(List<Integer>[] adjLists, boolean[] visited, int node) {
		visited[node] = true;

		boolean result = adjLists[node].size() == 2;
		for (int adj : adjLists[node]) {
			if (!visited[adj] && !search(adjLists, visited, adj)) {
				result = false;
			}
		}

		return result;
	}
}
