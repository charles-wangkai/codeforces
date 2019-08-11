import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] parents = new int[N - 1];
		int[] distances = new int[N - 1];
		for (int i = 0; i < N - 1; i++) {
			parents[i] = sc.nextInt();
			distances[i] = sc.nextInt();
		}
		System.out.print(solve(parents, distances));

		sc.close();
	}

	static String solve(int[] parents, int[] distances) {
		int N = parents.length + 1;

		@SuppressWarnings("unchecked")
		List<Edge>[] edgeLists = new List[N];
		for (int i = 0; i < edgeLists.length; i++) {
			edgeLists[i] = new ArrayList<>();
		}
		for (int i = 0; i < parents.length; i++) {
			edgeLists[parents[i] - 1].add(new Edge(i + 1, distances[i]));
		}

		long[] maxSubtreeDistances = new long[N];
		searchSubtree(edgeLists, maxSubtreeDistances, 0);

		long[] maxDistances = new long[N];
		searchAll(edgeLists, maxDistances, maxSubtreeDistances, 0, 0);

		return Arrays.stream(maxDistances).mapToObj(String::valueOf)
				.collect(Collectors.joining(System.lineSeparator()));
	}

	static void searchAll(List<Edge>[] edgeLists, long[] maxDistances, long[] maxSubtreeDistances,
			long maxDistanceFromParent, int node) {
		SortedMap<Long, Integer> distanceToCount = new TreeMap<>();
		addToMap(distanceToCount, maxDistanceFromParent);
		for (Edge edge : edgeLists[node]) {
			addToMap(distanceToCount, edge.distance + maxSubtreeDistances[edge.child]);
		}

		maxDistances[node] = distanceToCount.lastKey();

		for (Edge edge : edgeLists[node]) {
			removeFromMap(distanceToCount, edge.distance + maxSubtreeDistances[edge.child]);

			searchAll(edgeLists, maxDistances, maxSubtreeDistances, edge.distance + distanceToCount.lastKey(),
					edge.child);

			addToMap(distanceToCount, edge.distance + maxSubtreeDistances[edge.child]);
		}
	}

	static void addToMap(SortedMap<Long, Integer> distanceToCount, long distance) {
		distanceToCount.put(distance, distanceToCount.getOrDefault(distance, 0) + 1);
	}

	static void removeFromMap(SortedMap<Long, Integer> distanceToCount, long distance) {
		distanceToCount.put(distance, distanceToCount.get(distance) - 1);
		distanceToCount.remove(distance, 0);
	}

	static void searchSubtree(List<Edge>[] edgeLists, long[] maxSubtreeDistances, int node) {
		for (Edge edge : edgeLists[node]) {
			searchSubtree(edgeLists, maxSubtreeDistances, edge.child);

			maxSubtreeDistances[node] = Math.max(maxSubtreeDistances[node],
					edge.distance + maxSubtreeDistances[edge.child]);
		}
	}
}

class Edge {
	int child;
	int distance;

	Edge(int child, int distance) {
		this.child = child;
		this.distance = distance;
	}
}