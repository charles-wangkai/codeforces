import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] u = new int[n - 1];
    int[] v = new int[n - 1];
    for (int i = 0; i < n - 1; ++i) {
      st = new StringTokenizer(br.readLine());
      u[i] = Integer.parseInt(st.nextToken());
      v[i] = Integer.parseInt(st.nextToken());
    }
    int[][] q = new int[m][];
    for (int i = 0; i < q.length; ++i) {
      st = new StringTokenizer(br.readLine());
      int k = Integer.parseInt(st.nextToken());
      q[i] = new int[k];
      for (int j = 0; j < q[i].length; ++j) {
        q[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    System.out.println(solve(u, v, q));
  }

  static String solve(int[] u, int[] v, int[][] q) {
    int n = u.length + 1;

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[n];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < u.length; ++i) {
      adjLists[u[i] - 1].add(v[i] - 1);
      adjLists[v[i] - 1].add(u[i] - 1);
    }

    int[] depths = new int[n];
    int[][] parents = new int[n][Integer.toBinaryString(n).length()];
    search(depths, parents, adjLists, 0, -1, 0);

    int[] sortedNodes =
        IntStream.range(0, n)
            .boxed()
            .sorted(Comparator.comparing(i -> depths[i]))
            .mapToInt(Integer::intValue)
            .toArray();
    for (int node : sortedNodes) {
      for (int i = 1; i < parents[node].length; ++i) {
        parents[node][i] = (parents[node][i - 1] == -1) ? -1 : parents[parents[node][i - 1]][i - 1];
      }
    }

    return Arrays.stream(q)
        .map(
            qi -> {
              int[] nodes =
                  Arrays.stream(qi)
                      .map(x -> parents[x - 1][0])
                      .filter(node -> node != -1)
                      .boxed()
                      .sorted(Comparator.comparing(node -> depths[node]))
                      .mapToInt(Integer::intValue)
                      .toArray();

              return IntStream.range(0, nodes.length - 1)
                  .allMatch(
                      i ->
                          findAncestor(
                                  parents, nodes[i + 1], depths[nodes[i + 1]] - depths[nodes[i]])
                              == nodes[i]);
            })
        .map(x -> x ? "YES" : "NO")
        .collect(Collectors.joining("\n"));
  }

  static int findAncestor(int[][] parents, int node, int step) {
    int result = node;
    for (int i = parents[0].length - 1; i >= 0; --i) {
      if ((1 << i) <= step) {
        result = parents[result][i];
        step -= 1 << i;
      }
    }

    return result;
  }

  static void search(
      int[] depths, int[][] parents, List<Integer>[] adjLists, int depth, int parent, int node) {
    depths[node] = depth;
    parents[node][0] = parent;

    for (int adj : adjLists[node]) {
      if (adj != parent) {
        search(depths, parents, adjLists, depth + 1, node, adj);
      }
    }
  }
}