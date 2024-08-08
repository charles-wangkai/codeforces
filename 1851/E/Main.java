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
      int k = sc.nextInt();
      int[] c = new int[n];
      for (int i = 0; i < c.length; ++i) {
        c[i] = sc.nextInt();
      }
      int[] p = new int[k];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }
      int[][] e = new int[n][];
      for (int i = 0; i < e.length; ++i) {
        int m = sc.nextInt();
        e[i] = new int[m];
        for (int j = 0; j < e[i].length; ++j) {
          e[i][j] = sc.nextInt();
        }
      }

      System.out.println(solve(c, p, e));
    }

    sc.close();
  }

  static String solve(int[] c, int[] p, int[][] e) {
    int n = c.length;

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[n];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < e.length; ++i) {
      for (int ei : e[i]) {
        adjLists[ei - 1].add(i);
      }
    }

    List<Integer> sorted = topologicalSort(adjLists);

    for (int pi : p) {
      c[pi - 1] = 0;
    }

    int[] result = new int[n];
    for (int node : sorted) {
      result[node] =
          (int)
              Math.min(
                  c[node],
                  (e[node].length == 0)
                      ? Integer.MAX_VALUE
                      : Arrays.stream(e[node]).map(v -> result[v - 1]).asLongStream().sum());
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