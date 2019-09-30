import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] x = new int[n - 1];
		int[] y = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		System.out.println(solve(x, y, a) ? "Yes" : "No");

		sc.close();
	}

	static boolean solve(int[] x, int[] y, int[] a) {
		int n = a.length;

		@SuppressWarnings("unchecked")
		List<Integer>[] adjLists = new List[n + 1];
		for (int i = 1; i < adjLists.length; i++) {
			adjLists[i] = new ArrayList<>();
		}

		for (int i = 0; i < x.length; i++) {
			adjLists[x[i]].add(y[i]);
			adjLists[y[i]].add(x[i]);
		}

		boolean[] visited = new boolean[n + 1];
		visited[1] = true;

		Queue<Set<Integer>> queue = new LinkedList<>();
		queue.offer(new HashSet<>(Arrays.asList(1)));

		for (int ai : a) {
			Set<Integer> head = queue.peek();
			if (!head.contains(ai)) {
				return false;
			}

			head.remove(ai);
			if (head.isEmpty()) {
				queue.poll();
			}

			Set<Integer> set = new HashSet<>();
			for (int adj : adjLists[ai]) {
				if (!visited[adj]) {
					visited[adj] = true;
					set.add(adj);
				}
			}
			if (!set.isEmpty()) {
				queue.offer(set);
			}
		}

		return true;
	}
}
