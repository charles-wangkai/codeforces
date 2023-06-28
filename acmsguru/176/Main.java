// https://blog.csdn.net/m0_72495985/article/details/127864169
// https://blog.csdn.net/Richard__Luan/article/details/81002097
// https://blog.csdn.net/m0_72345017/article/details/127859612

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    int[] U = new int[M];
    int[] V = new int[M];
    int[] Z = new int[M];
    int[] C = new int[M];
    for (int i = 0; i < M; ++i) {
      U[i] = sc.nextInt();
      V[i] = sc.nextInt();
      Z[i] = sc.nextInt();
      C[i] = sc.nextInt();
    }

    System.out.println(solve(N, U, V, Z, C));

    sc.close();
  }

  static String solve(int N, int[] U, int[] V, int[] Z, int[] C) {
    int M = U.length;

    List<Edge> edges = new ArrayList<>();

    @SuppressWarnings("unchecked")
    List<Integer>[] edgeLists = new List[N + 2];
    for (int i = 0; i < edgeLists.length; ++i) {
      edgeLists[i] = new ArrayList<>();
    }

    int[] flows = new int[N + 2];
    Map<Integer, Integer> pipeIndexToReversedEdgeIndex = new HashMap<>();
    for (int i = 0; i < M; ++i) {
      if (C[i] == 1) {
        flows[U[i]] -= Z[i];
        flows[V[i]] += Z[i];
      } else {
        addEdges(edges, edgeLists, U[i], V[i], Z[i]);
        pipeIndexToReversedEdgeIndex.put(i, edges.size() - 1);
      }
    }

    for (int i = 1; i <= N; ++i) {
      if (flows[i] > 0) {
        addEdges(edges, edgeLists, 0, i, flows[i]);
        flows[0] += flows[i];
      } else if (flows[i] < 0) {
        addEdges(edges, edgeLists, i, N + 1, -flows[i]);
        flows[N + 1] += -flows[i];
      }
    }

    int maxflow = dinic(edges, edgeLists, 0, N + 1);
    addEdges(edges, edgeLists, N, 1, Integer.MAX_VALUE);
    maxflow += dinic(edges, edgeLists, 0, N + 1);

    return (maxflow == flows[0])
        ? String.format(
            "%d%s%s",
            edges.get(edges.size() - 1).capacity,
            System.lineSeparator(),
            IntStream.range(0, M)
                .map(
                    i ->
                        (C[i] == 1)
                            ? Z[i]
                            : edges.get(pipeIndexToReversedEdgeIndex.get(i)).capacity)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")))
        : "Impossible";
  }

  static void addEdges(List<Edge> edges, List<Integer>[] edgeLists, int u, int v, int z) {
    edges.add(new Edge(u, v, z));
    edgeLists[u].add(edges.size() - 1);

    edges.add(new Edge(v, u, 0));
    edgeLists[v].add(edges.size() - 1);
  }

  static int dinic(List<Edge> edges, List<Integer>[] edgeLists, int s, int t) {
    int result = 0;
    while (true) {
      int[] levels = bfs(edges, edgeLists, s, t);
      if (levels == null) {
        break;
      }

      while (true) {
        int minflow = dfs(edges, edgeLists, levels, s, t, Integer.MAX_VALUE);
        if (minflow == 0) {
          break;
        }

        result += minflow;
      }
    }

    return result;
  }

  static int[] bfs(List<Edge> edges, List<Integer>[] edgeLists, int s, int t) {
    int[] levels = new int[edges.size()];
    Arrays.fill(levels, -1);
    levels[s] = 0;

    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(s);

    while (!queue.isEmpty()) {
      int head = queue.poll();
      if (head == t) {
        return levels;
      }

      for (int e : edgeLists[head]) {
        Edge edge = edges.get(e);
        if (edge.capacity != 0 && levels[edge.to] == -1) {
          levels[edge.to] = levels[head] + 1;
          queue.offer(edge.to);
        }
      }
    }

    return null;
  }

  static int dfs(List<Edge> edges, List<Integer>[] edgeLists, int[] levels, int s, int t, int low) {
    if (s == t) {
      return low;
    }

    int result = 0;
    for (int e : edgeLists[s]) {
      Edge edge = edges.get(e);
      if (edge.capacity != 0 && levels[edge.to] == levels[s] + 1) {
        int next = dfs(edges, edgeLists, levels, edge.to, t, Math.min(low - result, edge.capacity));
        edge.capacity -= next;
        edges.get(e ^ 1).capacity += next;

        result += next;
        if (result == low) {
          break;
        }
      }
    }

    if (result == 0) {
      levels[s] = -1;
    }

    return result;
  }
}

class Edge {
  int from;
  int to;
  int capacity;

  Edge(int from, int to, int capacity) {
    this.from = from;
    this.to = to;
    this.capacity = capacity;
  }
}
