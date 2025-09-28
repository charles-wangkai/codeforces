import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] u = new int[n - 1];
      int[] v = new int[n - 1];
      int[] x = new int[n - 1];
      int[] y = new int[n - 1];
      for (int i = 0; i < n - 1; ++i) {
        u[i] = sc.nextInt();
        v[i] = sc.nextInt();
        x[i] = sc.nextInt();
        y[i] = sc.nextInt();
      }

      System.out.println(solve(u, v, x, y));
    }

    sc.close();
  }

  static String solve(int[] u, int[] v, int[] x, int[] y) {
    int n = u.length + 1;

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[n];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < u.length; ++i) {
      if (x[i] < y[i]) {
        adjLists[u[i] - 1].add(v[i] - 1);
      } else {
        adjLists[v[i] - 1].add(u[i] - 1);
      }
    }

    List<Integer> sorted = topologicalSort(adjLists);

    int[] result = new int[n];
    for (int i = 0; i < sorted.size(); ++i) {
      result[sorted.get(i)] = i + 1;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static List<Integer> topologicalSort(List<Integer>[] adjLists) {
    int n = adjLists.length;

    List<Integer> sorted = new ArrayList<>();
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; ++i) {
      if (!visited[i]) {
        search(sorted, adjLists, visited, i);
      }
    }
    Collections.reverse(sorted);

    return sorted;
  }

  static void search(List<Integer> sorted, List<Integer>[] adjLists, boolean[] visited, int node) {
    visited[node] = true;

    for (int adj : adjLists[node]) {
      if (!visited[adj]) {
        search(sorted, adjLists, visited, adj);
      }
    }

    sorted.add(node);
  }
}