import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] P = new int[M];
    int[] Q = new int[M];
    for (int i = 0; i < M; ++i) {
      P[i] = sc.nextInt();
      Q[i] = sc.nextInt();
    }

    System.out.println(solve(N, P, Q));

    sc.close();
  }

  static String solve(int N, int[] P, int[] Q) {
    Scc scc = new Scc(N);
    for (int i = 0; i < P.length; ++i) {
      scc.addEdge(P[i] - 1, Q[i] - 1);
    }

    List<Integer> sorted = scc.topologicalSort();
    int[] result = new int[N];
    for (int i = 0; i < sorted.size(); ++i) {
      result[sorted.get(i)] = i + 1;
    }

    return IntStream.range(0, P.length).allMatch(i -> result[P[i] - 1] < result[Q[i] - 1])
        ? Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "))
        : "No solution";
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
