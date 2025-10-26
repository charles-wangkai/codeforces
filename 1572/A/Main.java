import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[][] a = new int[n][];
      for (int i = 0; i < a.length; ++i) {
        int k = sc.nextInt();
        a[i] = new int[k];
        for (int j = 0; j < a[i].length; ++j) {
          a[i][j] = sc.nextInt();
        }
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[][] a) {
    int n = a.length;

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[n];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < a.length; ++i) {
      for (int aij : a[i]) {
        adjLists[aij - 1].add(i);
      }
    }

    List<Integer> sorted = topologicalSort(adjLists);

    int[] times = new int[n];
    for (int node : sorted) {
      if (a[node].length == 0) {
        times[node] = 1;
      } else {
        for (int aij : a[node]) {
          if (times[aij - 1] == 0) {
            return -1;
          }

          times[node] = Math.max(times[node], times[aij - 1] + ((aij - 1 > node) ? 1 : 0));
        }
      }
    }

    return Arrays.stream(times).max().getAsInt();
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