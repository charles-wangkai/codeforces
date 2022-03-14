import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m1 = sc.nextInt();
    int m2 = sc.nextInt();
    int[] u1 = new int[m1];
    int[] v1 = new int[m1];
    for (int i = 0; i < m1; ++i) {
      u1[i] = sc.nextInt() - 1;
      v1[i] = sc.nextInt() - 1;
    }
    int[] u2 = new int[m2];
    int[] v2 = new int[m2];
    for (int i = 0; i < m2; ++i) {
      u2[i] = sc.nextInt() - 1;
      v2[i] = sc.nextInt() - 1;
    }

    System.out.println(solve(n, u1, v1, u2, v2));

    sc.close();
  }

  static String solve(int n, int[] u1, int[] v1, int[] u2, int[] v2) {
    int[] parents1 = buildParents(n, u1, v1);
    int[] parents2 = buildParents(n, u2, v2);

    List<String> addedEdges = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      for (int j = i + 1; j < n; ++j) {
        int iRoot1 = findRoot(parents1, i);
        int jRoot1 = findRoot(parents1, j);
        int iRoot2 = findRoot(parents2, i);
        int jRoot2 = findRoot(parents2, j);
        if (iRoot1 != jRoot1 && iRoot2 != jRoot2) {
          parents1[jRoot1] = iRoot1;
          parents2[jRoot2] = iRoot2;

          addedEdges.add(String.format("%d %d", i + 1, j + 1));
        }
      }
    }

    return String.format("%d\n%s", addedEdges.size(), String.join("\n", addedEdges));
  }

  static int[] buildParents(int n, int[] u, int[] v) {
    int[] parents = new int[n];
    Arrays.fill(parents, -1);
    for (int i = 0; i < u.length; ++i) {
      parents[findRoot(parents, v[i])] = findRoot(parents, u[i]);
    }

    return parents;
  }

  static int findRoot(int[] parents, int node) {
    int root = node;
    while (parents[root] != -1) {
      root = parents[root];
    }

    int p = node;
    while (p != root) {
      int next = parents[p];
      parents[p] = root;

      p = next;
    }

    return root;
  }
}