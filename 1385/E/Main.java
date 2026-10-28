import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for (int tc = 0; tc < T; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] t = new int[m];
      int[] x = new int[m];
      int[] y = new int[m];
      for (int i = 0; i < m; ++i) {
        t[i] = sc.nextInt();
        x[i] = sc.nextInt();
        y[i] = sc.nextInt();
      }

      System.out.println(solve(n, t, x, y));
    }

    sc.close();
  }

  static String solve(int n, int[] t, int[] x, int[] y) {
    int m = t.length;

    Scc scc = new Scc(n);
    for (int i = 0; i < m; ++i) {
      if (t[i] == 1) {
        scc.addEdge(x[i] - 1, y[i] - 1);
      }
    }

    List<Integer> sorted = scc.topologicalSort();
    Map<Integer, Integer> nodeToIndex =
        IntStream.range(0, sorted.size()).boxed().collect(Collectors.toMap(sorted::get, i -> i));

    List<String> edges = new ArrayList<>();
    for (int i = 0; i < m; ++i) {
      if (nodeToIndex.get(x[i] - 1) < nodeToIndex.get(y[i] - 1)) {
        edges.add("%d %d".formatted(x[i], y[i]));
      } else if (t[i] == 0) {
        edges.add("%d %d".formatted(y[i], x[i]));
      } else {
        return "NO";
      }
    }

    return "YES\n%s".formatted(String.join("\n", edges));
  }
}

class Scc {
  List<Integer>[] adjLists;
  List<Integer>[] reversedAdjLists;

  @SuppressWarnings("unchecked")
  Scc(int n) {
    adjLists = new List[n];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }

    reversedAdjLists = new List[n];
    for (int i = 0; i < reversedAdjLists.length; ++i) {
      reversedAdjLists[i] = new ArrayList<>();
    }
  }

  void addEdge(int from, int to) {
    adjLists[from].add(to);
    reversedAdjLists[to].add(from);
  }

  List<Integer> topologicalSort() {
    int n = adjLists.length;

    List<Integer> sorted = new ArrayList<>();
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; ++i) {
      if (!visited[i]) {
        search1(sorted, visited, i);
      }
    }
    Collections.reverse(sorted);

    return sorted;
  }

  private void search1(List<Integer> sorted, boolean[] visited, int node) {
    visited[node] = true;

    for (int adj : adjLists[node]) {
      if (!visited[adj]) {
        search1(sorted, visited, adj);
      }
    }

    sorted.add(node);
  }

  int[] buildComponents() {
    int n = adjLists.length;

    List<Integer> sorted = topologicalSort();

    int[] components = new int[n];
    Arrays.fill(components, -1);
    int component = 0;
    for (int node : sorted) {
      if (components[node] == -1) {
        search2(components, component, node);
        ++component;
      }
    }

    return components;
  }

  private void search2(int[] components, int component, int node) {
    components[node] = component;

    for (int adj : reversedAdjLists[node]) {
      if (components[adj] == -1) {
        search2(components, component, adj);
      }
    }
  }
}
