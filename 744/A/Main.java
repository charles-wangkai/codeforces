import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();
    int[] c = new int[k];
    for (int i = 0; i < c.length; ++i) {
      c[i] = sc.nextInt();
    }
    int[] u = new int[m];
    int[] v = new int[m];
    for (int i = 0; i < m; ++i) {
      u[i] = sc.nextInt();
      v[i] = sc.nextInt();
    }

    System.out.println(solve(n, u, v, c));

    sc.close();
  }

  static int solve(int n, int[] u, int[] v, int[] c) {
    Set<Integer> homes = Arrays.stream(c).map(ci -> ci - 1).boxed().collect(Collectors.toSet());

    int[] parents = new int[n];
    Arrays.fill(parents, -1);

    for (int i = 0; i < u.length; ++i) {
      int root1 = findRoot(parents, u[i] - 1);
      int root2 = findRoot(parents, v[i] - 1);
      if (root1 != root2) {
        if (homes.contains(root1)) {
          parents[root2] = root1;
        } else {
          parents[root1] = root2;
        }
      }
    }

    int homeWithMaxSize = findHomeWithMaxSize(homes, parents);
    for (int i = 0; i < n; ++i) {
      int root = findRoot(parents, i);
      if (!homes.contains(root)) {
        parents[root] = homeWithMaxSize;
      }
    }

    Map<Integer, Integer> homeToEdgeCount = new HashMap<>();
    for (int i = 0; i < u.length; ++i) {
      int home = findRoot(parents, u[i] - 1);
      homeToEdgeCount.put(home, homeToEdgeCount.getOrDefault(home, 0) + 1);
    }

    Map<Integer, Integer> homeToSize = new HashMap<>();
    for (int i = 0; i < parents.length; ++i) {
      int root = findRoot(parents, i);
      homeToSize.put(root, homeToSize.getOrDefault(root, 0) + 1);
    }

    return homeToSize.keySet().stream()
        .mapToInt(
            home ->
                homeToSize.get(home) * (homeToSize.get(home) - 1) / 2
                    - homeToEdgeCount.getOrDefault(home, 0))
        .sum();
  }

  static int findHomeWithMaxSize(Set<Integer> homes, int[] parents) {
    Map<Integer, Integer> homeToSize = new HashMap<>();
    for (int i = 0; i < parents.length; ++i) {
      int root = findRoot(parents, i);
      if (homes.contains(root)) {
        homeToSize.put(root, homeToSize.getOrDefault(root, 0) + 1);
      }
    }

    return homeToSize.keySet().stream().max(Comparator.comparing(homeToSize::get)).get();
  }

  static int findRoot(int[] parents, int node) {
    if (parents[node] == -1) {
      return node;
    }

    parents[node] = findRoot(parents, parents[node]);

    return parents[node];
  }
}