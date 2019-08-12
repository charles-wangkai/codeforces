import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int count1;
	static int count2;

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

	static long solve(int[] u, int[] v) {
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

		count1 = 0;
		count2 = 0;
		search(adjLists, new boolean[n], 0, true);

		return (long) count1 * count2 - (n - 1);
	}

	static void search(List<Integer>[] adjLists, boolean[] visited, int node, boolean set1Or2) {
		visited[node] = true;

		if (set1Or2) {
			count1++;
		} else {
			count2++;
		}

		for (int adj : adjLists[node]) {
			if (!visited[adj]) {
				search(adjLists, visited, adj, !set1Or2);
			}
		}
	}
}
