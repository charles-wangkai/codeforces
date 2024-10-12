import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    sc.nextInt();
    int m = sc.nextInt();
    String s = sc.next();
    int[] x = new int[m];
    int[] y = new int[m];
    for (int i = 0; i < m; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    System.out.println(solve(s, x, y));

    sc.close();
  }

  static int solve(String s, int[] x, int[] y) {
    int n = s.length();

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[n];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < x.length; ++i) {
      adjLists[x[i] - 1].add(y[i] - 1);
    }

    List<Integer> sorted = topologicalSort(adjLists);

    Map<Integer, Integer> nodeToIndex =
        IntStream.range(0, sorted.size()).boxed().collect(Collectors.toMap(sorted::get, i -> i));
    if (IntStream.range(0, x.length)
        .anyMatch(i -> nodeToIndex.get(x[i] - 1) >= nodeToIndex.get(y[i] - 1))) {
      return -1;
    }

    int[][] dp = new int[n][26];
    for (int node : sorted) {
      ++dp[node][s.charAt(node) - 'a'];
      for (int adj : adjLists[node]) {
        for (int i = 0; i < 26; ++i) {
          dp[adj][i] = Math.max(dp[adj][i], dp[node][i]);
        }
      }
    }

    int result = 0;
    for (int[] dpi : dp) {
      for (int dpij : dpi) {
        result = Math.max(result, dpij);
      }
    }

    return result;
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