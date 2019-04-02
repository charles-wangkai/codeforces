import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		@SuppressWarnings("unchecked")
		List<Edge>[] adjLists = new List[n + 1];
		for (int i = 1; i < adjLists.length; i++) {
			adjLists[i] = new ArrayList<>();
		}
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int weight = sc.nextInt();

			adjLists[a].add(new Edge(b, weight));
			adjLists[b].add(new Edge(a, weight));
		}
		System.out.println(solve(adjLists));

		sc.close();
	}

	static String solve(List<Edge>[] adjLists) {
		int n = adjLists.length - 1;

		long[] distances = new long[n + 1];
		Arrays.fill(distances, Long.MAX_VALUE);

		int[] prevVertices = new int[n + 1];

		distances[1] = 0;
		PriorityQueue<Element> pq = new PriorityQueue<>(
				(element1, element2) -> Long.compare(element1.distance, element2.distance));
		pq.offer(new Element(1, 0));
		while (!pq.isEmpty()) {
			Element head = pq.poll();

			for (Edge edge : adjLists[head.to]) {
				if (distances[head.to] + edge.weight < distances[edge.to]) {
					distances[edge.to] = distances[head.to] + edge.weight;
					prevVertices[edge.to] = head.to;

					pq.offer(new Element(edge.to, distances[edge.to]));
				}
			}
		}

		if (distances[n] == Long.MAX_VALUE) {
			return "-1";
		}

		List<Integer> path = new ArrayList<>();
		for (int v = n; v != 0; v = prevVertices[v]) {
			path.add(v);
		}
		Collections.reverse(path);

		return path.stream().map(String::valueOf).collect(Collectors.joining(" "));
	}
}

class Edge {
	int to;
	int weight;

	Edge(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}
}

class Element {
	int to;
	long distance;

	Element(int to, long distance) {
		this.to = to;
		this.distance = distance;
	}
}