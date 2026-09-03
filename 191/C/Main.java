import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] u = new int[n - 1];
    int[] v = new int[n - 1];
    for (int i = 0; i < n - 1; ++i) {
      u[i] = sc.nextInt();
      v[i] = sc.nextInt();
    }
    int k = sc.nextInt();
    int[] a = new int[k];
    int[] b = new int[k];
    for (int i = 0; i < k; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    System.out.println(solve(u, v, a, b));

    sc.close();
  }

  static String solve(int[] u, int[] v, int[] a, int[] b) {
    Tree tree =
        new Tree(
            Arrays.stream(u).map(ui -> ui - 1).toArray(),
            Arrays.stream(v).map(vi -> vi - 1).toArray(),
            0);

    for (int i = 0; i < a.length; ++i) {
      int node1 = a[i] - 1;
      int node2 = b[i] - 1;

      int lca = tree.findLca(node1, node2);

      tree.deltas[node1] += 1;
      tree.deltas[node2] += 1;
      tree.deltas[lca] -= 2;
    }

    tree.buildDeltaSums(-1, tree.root);

    return IntStream.range(0, tree.u.length)
        .map(
            i ->
                (tree.depths[tree.u[i]] > tree.depths[tree.v[i]])
                    ? tree.deltas[tree.u[i]]
                    : tree.deltas[tree.v[i]])
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}

class Tree {
  int n;
  int[] u;
  int[] v;
  int root;
  List<Integer>[] edgeLists;
  int[] depths;
  int[][] ancestors;
  int[] deltas;

  @SuppressWarnings("unchecked")
  Tree(int[] u, int[] v, int root) {
    n = u.length + 1;

    this.u = u;
    this.v = v;
    this.root = root;

    edgeLists = new List[n];
    for (int i = 0; i < edgeLists.length; ++i) {
      edgeLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < u.length; ++i) {
      edgeLists[u[i]].add(i);
      edgeLists[v[i]].add(i);
    }

    depths = new int[n];
    ancestors = new int[n][Integer.toBinaryString(n).length()];
    init(0, -1, root);

    deltas = new int[n];
  }

  private void init(int depth, int parent, int node) {
    depths[node] = depth;

    ancestors[node][0] = parent;
    for (int i = 1; i < ancestors[node].length; ++i) {
      ancestors[node][i] =
          (ancestors[node][i - 1] == -1) ? -1 : ancestors[ancestors[node][i - 1]][i - 1];
    }

    for (int edge : edgeLists[node]) {
      int adj = (node == u[edge]) ? v[edge] : u[edge];
      if (adj != parent) {
        init(depth + 1, node, adj);
      }
    }
  }

  int findLca(int node1, int node2) {
    if (depths[node1] < depths[node2]) {
      return findLca(node2, node1);
    }

    for (int i = ancestors[node1].length - 1; i >= 0; --i) {
      if (ancestors[node1][i] != -1 && depths[ancestors[node1][i]] >= depths[node2]) {
        node1 = ancestors[node1][i];
      }
    }

    if (node1 == node2) {
      return node1;
    }

    for (int i = ancestors[node1].length - 1; i >= 0; --i) {
      if (ancestors[node1][i] != ancestors[node2][i]) {
        node1 = ancestors[node1][i];
        node2 = ancestors[node2][i];
      }
    }

    return ancestors[node1][0];
  }

  void buildDeltaSums(int parent, int node) {
    for (int edge : edgeLists[node]) {
      int adj = (node == u[edge]) ? v[edge] : u[edge];
      if (adj != parent) {
        buildDeltaSums(node, adj);
        deltas[node] += deltas[adj];
      }
    }
  }
}
