import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
	System.out.println(solve(x, y));

	sc.close();
    }

    static String solve(int[] x, int[] y) {
	int n = x.length + 1;

	@SuppressWarnings("unchecked")
	List<Integer>[] adjLists = new List[n];
	for (int i = 0; i < adjLists.length; i++) {
	    adjLists[i] = new ArrayList<>();
	}

	for (int i = 0; i < x.length; i++) {
	    adjLists[x[i] - 1].add(y[i] - 1);
	    adjLists[y[i] - 1].add(x[i] - 1);
	}

	int[] colors = new int[n];
	search(adjLists, colors, new boolean[n], 0, 1, -1);

	return String.format("%d\n%s", Arrays.stream(colors).max().getAsInt(),
		Arrays.stream(colors).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }

    static void search(List<Integer>[] adjLists, int[] colors, boolean[] visited, int node, int nodeColor,
	    int parentColor) {
	colors[node] = nodeColor;
	visited[node] = true;

	int color = 0;
	for (int adj : adjLists[node]) {
	    if (!visited[adj]) {
		color++;
		while (color == nodeColor || color == parentColor) {
		    color++;
		}

		search(adjLists, colors, visited, adj, color, nodeColor);
	    }
	}
    }
}
