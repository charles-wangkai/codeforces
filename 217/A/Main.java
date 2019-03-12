import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		System.out.println(solve(x, y));

		sc.close();
	}

	static int solve(int[] x, int[] y) {
		int n = x.length;

		@SuppressWarnings("unchecked")
		List<Integer>[] adjacentLists = new List[n];
		for (int i = 0; i < adjacentLists.length; i++) {
			adjacentLists[i] = new ArrayList<>();
		}

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (x[i] == x[j] || y[i] == y[j]) {
					adjacentLists[i].add(j);
					adjacentLists[j].add(i);
				}
			}
		}

		int componentNum = 0;
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				search(adjacentLists, visited, i);

				componentNum++;
			}
		}
		return componentNum - 1;
	}

	static void search(List<Integer>[] adjacentLists, boolean[] visited, int current) {
		visited[current] = true;

		for (int adjacent : adjacentLists[current]) {
			if (!visited[adjacent]) {
				search(adjacentLists, visited, adjacent);
			}
		}
	}
}