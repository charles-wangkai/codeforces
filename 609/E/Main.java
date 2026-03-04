// https://codeforces.com/blog/entry/22187

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] u = new int[m];
    int[] v = new int[m];
    int[] w = new int[m];
    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      u[i] = Integer.parseInt(st.nextToken());
      v[i] = Integer.parseInt(st.nextToken());
      w[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solve(n, u, v, w));
  }

  static String solve(int n, int[] u, int[] v, int[] w) {
    int[] sortedIndices =
        IntStream.range(0, u.length)
            .boxed()
            .sorted(Comparator.comparing(i -> w[i]))
            .mapToInt(Integer::intValue)
            .toArray();

    Dsu dsu = new Dsu(n);
    List<Integer> node1s = new ArrayList<>();
    List<Integer> node2s = new ArrayList<>();
    List<Integer> weights = new ArrayList<>();
    for (int index : sortedIndices) {
      int leader1 = dsu.find(u[index] - 1);
      int leader2 = dsu.find(v[index] - 1);
      if (leader1 != leader2) {
        dsu.union(u[index] - 1, v[index] - 1);

        node1s.add(u[index] - 1);
        node2s.add(v[index] - 1);
        weights.add(w[index]);
      }
    }

    long weightSum = weights.stream().mapToInt(Integer::intValue).asLongStream().sum();

    Tree tree =
        new Tree(
            node1s.stream().mapToInt(Integer::intValue).toArray(),
            node2s.stream().mapToInt(Integer::intValue).toArray(),
            weights.stream().mapToInt(Integer::intValue).toArray(),
            0);

    return IntStream.range(0, u.length)
        .mapToLong(
            i -> {
              int lca = tree.findLca(u[i] - 1, v[i] - 1);

              return weightSum
                  - Math.max(
                      tree.findBetweenMaxWeight(lca, u[i] - 1),
                      tree.findBetweenMaxWeight(lca, v[i] - 1))
                  + w[i];
            })
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}

class Dsu {
  int[] parentOrSizes;

  Dsu(int n) {
    parentOrSizes = new int[n];
    Arrays.fill(parentOrSizes, -1);
  }

  int find(int a) {
    if (parentOrSizes[a] < 0) {
      return a;
    }

    parentOrSizes[a] = find(parentOrSizes[a]);

    return parentOrSizes[a];
  }

  void union(int a, int b) {
    int aLeader = find(a);
    int bLeader = find(b);
    if (aLeader != bLeader) {
      parentOrSizes[aLeader] += parentOrSizes[bLeader];
      parentOrSizes[bLeader] = aLeader;
    }
  }

  int getSize(int a) {
    return -parentOrSizes[find(a)];
  }

  Map<Integer, List<Integer>> buildLeaderToGroup() {
    Map<Integer, List<Integer>> leaderToGroup = new HashMap<>();
    for (int i = 0; i < parentOrSizes.length; ++i) {
      int leader = find(i);
      leaderToGroup.putIfAbsent(leader, new ArrayList<>());
      leaderToGroup.get(leader).add(i);
    }

    return leaderToGroup;
  }
}

class Tree {
  int n;
  int[] u;
  int[] v;
  int[] weights;
  int root;
  List<Integer>[] edgeLists;
  int[] depths;
  int[][] ancestors;
  int[][] maxWeights;

  @SuppressWarnings("unchecked")
  Tree(int[] u, int[] v, int[] weights, int root) {
    n = u.length + 1;

    this.u = u;
    this.v = v;
    this.weights = weights;
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
    maxWeights = new int[n][Integer.toBinaryString(n).length()];
    init(0, -1, 0, root);
  }

  private void init(int depth, int parent, int weight, int node) {
    depths[node] = depth;

    ancestors[node][0] = parent;
    maxWeights[node][0] = weight;
    for (int i = 1; i < ancestors[node].length; ++i) {
      int ancestor = ancestors[node][i - 1];
      if (ancestor == -1) {
        ancestors[node][i] = -1;
      } else {
        ancestors[node][i] = ancestors[ancestor][i - 1];
        maxWeights[node][i] = Math.max(maxWeights[node][i - 1], maxWeights[ancestor][i - 1]);
      }
    }

    for (int edge : edgeLists[node]) {
      int adj = (node == u[edge]) ? v[edge] : u[edge];
      if (adj != parent) {
        init(depth + 1, node, weights[edge], adj);
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

  int findBetweenMaxWeight(int node1, int node2) {
    if (depths[node1] < depths[node2]) {
      return findBetweenMaxWeight(node2, node1);
    }

    int result = 0;
    for (int i = ancestors[node1].length - 1; i >= 0; --i) {
      if (ancestors[node1][i] != -1 && depths[ancestors[node1][i]] >= depths[node2]) {
        result = Math.max(result, maxWeights[node1][i]);
        node1 = ancestors[node1][i];
      }
    }

    return result;
  }
}
