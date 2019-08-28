import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

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

	static String solve(int n, int[] u, int[] v) {
		@SuppressWarnings("unchecked")
		Set<Integer>[] adjSets = new Set[n + 1];
		for (int i = 1; i <= n; i++) {
			adjSets[i] = new HashSet<>();
		}

		for (int i = 0; i < u.length; i++) {
			adjSets[u[i]].add(v[i]);
			adjSets[v[i]].add(u[i]);
		}

		List<Integer> result = new ArrayList<>();
		boolean[] visited = new boolean[n + 1];
		SortedSet<Integer> nextNodes = new TreeSet<>();
		nextNodes.add(1);
		while (!nextNodes.isEmpty()) {
			int node = nextNodes.first();

			result.add(node);
			visited[node] = true;
			nextNodes.remove(node);

			for (int adj : adjSets[node]) {
				if (!visited[adj]) {
					nextNodes.add(adj);
				}
			}
		}

		return result.stream().map(String::valueOf).collect(Collectors.joining(" "));
	}
}
