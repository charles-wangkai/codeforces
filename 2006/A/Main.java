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
      String s = sc.next();

      System.out.println(solve(u, v, s));
    }

    sc.close();
  }

  static int solve(int[] u, int[] v, String s) {
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

    int[] leafCounts = new int[3];
    search(leafCounts, s, adjLists, -1, 0);

    if (s.charAt(0) == '?') {
      if (leafCounts[0] == leafCounts[1]
          && (s.chars().filter(c -> c == '?').count() - (leafCounts[2] + 1)) % 2 == 1) {
        return leafCounts[0] + (leafCounts[2] + 1) / 2;
      }

      return Math.max(leafCounts[0], leafCounts[1]) + leafCounts[2] / 2;
    }

    return leafCounts[1 - (s.charAt(0) - '0')] + (leafCounts[2] + 1) / 2;
  }

  static void search(int[] leafCounts, String s, List<Integer>[] adjLists, int parent, int node) {
    if (adjLists[node].size() == 1 && adjLists[node].get(0) == parent) {
      ++leafCounts[(s.charAt(node) == '?') ? 2 : (s.charAt(node) - '0')];
    }

    for (int adj : adjLists[node]) {
      if (adj != parent) {
        search(leafCounts, s, adjLists, node, adj);
      }
    }
  }
}