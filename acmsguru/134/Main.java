import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	static int minAssociated;
	static List<Integer> verticesWithMinAssociated;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] a = new int[N - 1];
		int[] b = new int[N - 1];
		for (int i = 0; i < N - 1; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		System.out.print(solve(a, b));

		sc.close();
	}

	static String solve(int[] a, int[] b) {
		int N = a.length + 1;

		Node tree = buildTree(a, b);

		minAssociated = Integer.MAX_VALUE;
		verticesWithMinAssociated = new ArrayList<>();
		search(N, tree);
		Collections.sort(verticesWithMinAssociated);

		return String.format("%d %d\n%s", minAssociated, verticesWithMinAssociated.size(),
				verticesWithMinAssociated.stream().map(String::valueOf).collect(Collectors.joining(" ")));
	}

	static int search(int N, Node node) {
		int maxSubCount = 0;
		int totalSubCount = 0;
		for (Node child : node.children) {
			int subCount = search(N, child);

			maxSubCount = Math.max(maxSubCount, subCount);
			totalSubCount += subCount;
		}

		int associated = Math.max(maxSubCount, N - totalSubCount - 1);
		if (associated < minAssociated) {
			minAssociated = associated;

			verticesWithMinAssociated.clear();
			verticesWithMinAssociated.add(node.vertex);
		} else if (associated == minAssociated) {
			verticesWithMinAssociated.add(node.vertex);
		}

		return totalSubCount + 1;
	}

	static Node buildTree(int[] a, int[] b) {
		int N = a.length + 1;

		@SuppressWarnings("unchecked")
		List<Integer>[] adjLists = new List[N + 1];
		for (int i = 0; i < adjLists.length; i++) {
			adjLists[i] = new ArrayList<>();
		}

		for (int i = 0; i < a.length; i++) {
			adjLists[a[i]].add(b[i]);
			adjLists[b[i]].add(a[i]);
		}

		return buildNode(adjLists, new boolean[N + 1], 1);
	}

	static Node buildNode(List<Integer>[] adjLists, boolean[] visited, int vertex) {
		visited[vertex] = true;

		Node node = new Node(vertex);
		for (int adj : adjLists[vertex]) {
			if (!visited[adj]) {
				node.children.add(buildNode(adjLists, visited, adj));
			}
		}

		return node;
	}
}

class Node {
	int vertex;
	List<Node> children = new ArrayList<>();

	Node(int vertex) {
		this.vertex = vertex;
	}
}