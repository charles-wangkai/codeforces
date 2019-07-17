import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	static double expectedLength;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] u = new int[n - 1];
		int[] v = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			u[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		System.out.println(solve(u, v));

		sc.close();
	}

	static double solve(int[] u, int[] v) {
		int n = u.length + 1;

		@SuppressWarnings("unchecked")
		List<Integer>[] adjLists = new List[n];
		for (int i = 0; i < adjLists.length; i++) {
			adjLists[i] = new ArrayList<>();
		}

		for (int i = 0; i < u.length; i++) {
			adjLists[u[i] - 1].add(v[i] - 1);
			adjLists[v[i] - 1].add(u[i] - 1);
		}

		expectedLength = 0;
		search(adjLists, new boolean[n], 1, 0, 0);
		return expectedLength;
	}

	static void search(List<Integer>[] adjLists, boolean[] visited, double prob, int length, int node) {
		visited[node] = true;
		List<Integer> candidates = adjLists[node].stream().filter(adj -> !visited[adj]).collect(Collectors.toList());
		if (candidates.isEmpty()) {
			expectedLength += prob * length;
		} else {
			double nextProb = prob / candidates.size();

			for (int candidate : candidates) {
				search(adjLists, visited, nextProb, length + 1, candidate);
			}
		}
	}
}
