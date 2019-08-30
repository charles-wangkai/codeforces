import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] p = new int[n];
		for (int i = 0; i < p.length; i++) {
			p[i] = sc.nextInt();
		}
		char[][] A = new char[n][n];
		for (int i = 0; i < n; i++) {
			String line = sc.next();
			for (int j = 0; j < n; j++) {
				A[i][j] = line.charAt(j);
			}
		}
		System.out.println(solve(p, A));

		sc.close();
	}

	static String solve(int[] p, char[][] A) {
		boolean[] visited = new boolean[p.length];
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				List<Integer> indices = new ArrayList<>();
				search(indices, A, visited, i);

				sort(p, indices);
			}
		}

		return Arrays.stream(p).mapToObj(String::valueOf).collect(Collectors.joining(" "));
	}

	static void search(List<Integer> indices, char[][] A, boolean[] visited, int node) {
		visited[node] = true;
		indices.add(node);

		for (int i = 0; i < visited.length; i++) {
			if (!visited[i] && A[node][i] == '1') {
				search(indices, A, visited, i);
			}
		}
	}

	static void sort(int[] p, List<Integer> indices) {
		int[] sortedIndices = indices.stream().sorted().mapToInt(x -> x).toArray();
		int[] values = indices.stream().mapToInt(i -> p[i]).sorted().toArray();

		for (int i = 0; i < sortedIndices.length; i++) {
			p[sortedIndices[i]] = values[i];
		}
	}
}
