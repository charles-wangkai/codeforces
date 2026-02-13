import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[n];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < u.length; ++i) {
      adjLists[u[i] - 1].add(v[i] - 1);
      adjLists[v[i] - 1].add(u[i] - 1);
    }

    Map<Integer, List<Integer>> depthToParents = new HashMap<>();
    search(depthToParents, adjLists, -1, 0, 0);

    return depthToParents.values().stream()
        .mapToInt(parents -> parents.size() + ((parents.stream().distinct().count() == 1) ? 1 : 0))
        .max()
        .getAsInt();
  }

  static void search(
      Map<Integer, List<Integer>> depthToParents,
      List<Integer>[] adjLists,
      int parent,
      int node,
      int depth) {
    depthToParents.putIfAbsent(depth, new ArrayList<>());
    depthToParents.get(depth).add(parent);

    for (int adj : adjLists[node]) {
      if (adj != parent) {
        search(depthToParents, adjLists, node, adj, depth + 1);
      }
    }
  }
}