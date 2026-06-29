import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] u = new int[n - 1];
      int[] v = new int[n - 1];
      for (int i = 0; i < n - 1; ++i) {
        u[i] = sc.nextInt();
        v[i] = sc.nextInt();
      }

      System.out.println(solve(u, v));
    }

    sc.close();
  }

  static int solve(int[] u, int[] v) {
    int n = u.length + 1;

    int[] parents = new int[n];

    @SuppressWarnings("unchecked")
    List<Integer>[] childLists = new List[n];
    for (int i = 0; i < childLists.length; ++i) {
      childLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < u.length; ++i) {
      childLists[u[i] - 1].add(v[i] - 1);
      childLists[v[i] - 1].add(u[i] - 1);
    }

    search(parents, childLists, -1, 0);

    int[] degrees = new int[n];
    for (int i = 0; i < u.length; ++i) {
      ++degrees[u[i] - 1];
      ++degrees[v[i] - 1];
    }

    int result = Integer.MAX_VALUE;
    List<Integer> level = List.of(0);
    int rest = 0;
    while (!level.isEmpty()) {
      List<Integer> nextLevel = new ArrayList<>();
      for (int node : level) {
        if (childLists[node].isEmpty()) {
          int current = node;
          while (current != 0 && degrees[current] == 1) {
            --rest;

            current = parents[current];
            if (current != 0) {
              --degrees[current];
            }
          }
        } else {
          for (int child : childLists[node]) {
            nextLevel.add(child);
            ++rest;
          }
        }
      }

      result = Math.min(result, n - 1 - rest);

      level = nextLevel;
    }

    return result;
  }

  static void search(int[] parents, List<Integer>[] childLists, int parent, int node) {
    parents[node] = parent;
    childLists[node].remove(Integer.valueOf(parent));

    for (int child : childLists[node]) {
      search(parents, childLists, node, child);
    }
  }
}