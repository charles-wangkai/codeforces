import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] x = new int[m];
		int[] y = new int[m];
		for (int i = 0; i < m; i++) {
			x[i] = sc.nextInt() - 1;
			y[i] = sc.nextInt() - 1;
		}
		System.out.println(solve(n, x, y));

		sc.close();
	}

	static long solve(int n, int[] x, int[] y) {
		@SuppressWarnings("unchecked")
		List<Integer>[] adjLists = new List[n];
		for (int i = 0; i < adjLists.length; i++) {
			adjLists[i] = new ArrayList<>();
		}

		for (int i = 0; i < x.length; i++) {
			adjLists[x[i]].add(y[i]);
			adjLists[y[i]].add(x[i]);
		}

		long result = 1;
		boolean[] visited = new boolean[n];
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				result <<= search(adjLists, visited, i) - 1;
			}
		}

		return result;
	}

	static int search(List<Integer>[] adjLists, boolean[] visited, int node) {
		visited[node] = true;

		int result = 1;
		for (int adj : adjLists[node]) {
			if (!visited[adj]) {
				result += search(adjLists, visited, adj);
			}
		}

		return result;
	}
}
