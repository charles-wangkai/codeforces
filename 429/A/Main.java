import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] u = new int[n - 1];
		int[] v = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			u[i] = sc.nextInt() - 1;
			v[i] = sc.nextInt() - 1;
		}
		int[] inits = readArray(sc, n);
		int[] goals = readArray(sc, n);
		System.out.println(solve(u, v, inits, goals));

		sc.close();
	}

	static int[] readArray(Scanner sc, int size) {
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = sc.nextInt();
		}

		return result;
	}

	static String solve(int[] u, int[] v, int[] inits, int[] goals) {
		int n = inits.length;

		@SuppressWarnings("unchecked")
		List<Integer>[] adjLists = new List[n];
		for (int i = 0; i < adjLists.length; i++) {
			adjLists[i] = new ArrayList<>();
		}

		for (int i = 0; i < u.length; i++) {
			adjLists[u[i]].add(v[i]);
			adjLists[v[i]].add(u[i]);
		}

		Node root = buildNode(adjLists, inits, goals, new boolean[n], 0);

		List<Integer> picked = new ArrayList<>();
		search(picked, false, false, root);

		return String.format("%d\n%s", picked.size(),
				picked.stream().map(String::valueOf).collect(Collectors.joining("\n")));
	}

	static void search(List<Integer> picked, boolean currentFlipped, boolean nextFlipped, Node node) {
		int currentValue = currentFlipped ? (1 - node.init) : node.init;
		if (currentValue != node.goal) {
			picked.add(node.index + 1);
			currentFlipped = !currentFlipped;
		}

		for (Node child : node.children) {
			search(picked, nextFlipped, currentFlipped, child);
		}
	}

	static Node buildNode(List<Integer>[] adjLists, int[] inits, int[] goals, boolean[] visited, int index) {
		visited[index] = true;

		Node node = new Node(index, inits[index], goals[index]);
		for (int adj : adjLists[index]) {
			if (!visited[adj]) {
				node.children.add(buildNode(adjLists, inits, goals, visited, adj));
			}
		}

		return node;
	}
}

class Node {
	int index;
	int init;
	int goal;
	List<Node> children = new ArrayList<>();

	Node(int index, int init, int goal) {
		this.index = index;
		this.init = init;
		this.goal = goal;
	}
}