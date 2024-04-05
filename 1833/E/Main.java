import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    int n = a.length;

    int[] parents = new int[n];
    Arrays.fill(parents, -1);

    @SuppressWarnings("unchecked")
    Set<Integer>[] adjSets = new Set[n];
    for (int i = 0; i < adjSets.length; ++i) {
      adjSets[i] = new HashSet<>();
    }

    for (int i = 0; i < a.length; ++i) {
      int root1 = findRoot(parents, i);
      int root2 = findRoot(parents, a[i] - 1);
      if (root1 != root2) {
        parents[root2] = root1;
      }

      adjSets[i].add(a[i] - 1);
      adjSets[a[i] - 1].add(i);
    }

    Map<Integer, Boolean> groupToFree = new HashMap<>();
    for (int i = 0; i < n; ++i) {
      int root = findRoot(parents, i);
      groupToFree.putIfAbsent(root, false);

      if (adjSets[i].size() == 1) {
        groupToFree.put(root, true);
      }
    }

    return String.format(
        "%d %d",
        groupToFree.values().stream().filter(free -> !free).count()
            + (groupToFree.values().stream().anyMatch(free -> free) ? 1 : 0),
        groupToFree.size());
  }

  static int findRoot(int[] parents, int node) {
    if (parents[node] == -1) {
      return node;
    }

    parents[node] = findRoot(parents, parents[node]);

    return parents[node];
  }
}