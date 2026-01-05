// https://www.cnblogs.com/Emiya-wjk/p/10069117.html

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
    int[] u = new int[M];
    int[] v = new int[M];
    int[] l = new int[M];
    int[] c = new int[M];
    for (int i = 0; i < M; ++i) {
      u[i] = sc.nextInt();
      v[i] = sc.nextInt();
      l[i] = sc.nextInt();
      c[i] = sc.nextInt();
    }

    System.out.println(solve(N, u, v, l, c));

    sc.close();
  }

  static String solve(int N, int[] u, int[] v, int[] l, int[] c) {
    int M = u.length;

    MaxFlow maxFlow = new MaxFlow(N + 2);

    int[] flows = new int[N + 2];
    Map<Integer, Integer> pipeIndexToReversedEdgeIndex = new HashMap<>();
    for (int i = 0; i < M; ++i) {
      flows[u[i]] -= l[i];
      flows[v[i]] += l[i];

      maxFlow.addEdges(u[i], v[i], c[i] - l[i]);
      pipeIndexToReversedEdgeIndex.put(i, maxFlow.edges.size() - 1);
    }

    for (int i = 1; i <= N; ++i) {
      if (flows[i] > 0) {
        maxFlow.addEdges(0, i, flows[i]);
        flows[0] += flows[i];
      } else if (flows[i] < 0) {
        maxFlow.addEdges(i, N + 1, -flows[i]);
        flows[N + 1] += -flows[i];
      }
    }

    int maxflowValue = maxFlow.dinic(0, N + 1);

    return (maxflowValue == flows[0])
        ? "YES\n%s"
            .formatted(
                IntStream.range(0, M)
                    .map(
                        i -> l[i] + maxFlow.edges.get(pipeIndexToReversedEdgeIndex.get(i)).capacity)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining("\n")))
        : "NO";
  }
}

class MaxFlow {
  List<Edge> edges = new ArrayList<>();
  List<Integer>[] edgeLists;

  @SuppressWarnings("unchecked")
  MaxFlow(int size) {
    edgeLists = new List[size];
    for (int i = 0; i < edgeLists.length; ++i) {
      edgeLists[i] = new ArrayList<>();
    }
  }

  void addEdges(int u, int v, int cap) {
    edges.add(new Edge(u, v, cap));
    edgeLists[u].add(edges.size() - 1);

    edges.add(new Edge(v, u, 0));
    edgeLists[v].add(edges.size() - 1);
  }

  int dinic(int s, int t) {
    int result = 0;
    while (true) {
      int[] levels = bfs(s, t);
      if (levels == null) {
        break;
      }

      while (true) {
        int minflow = dfs(levels, s, t, Integer.MAX_VALUE);
        if (minflow == 0) {
          break;
        }

        result += minflow;
      }
    }

    return result;
  }

  private int[] bfs(int s, int t) {
    int[] levels = new int[edgeLists.length];
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

  private int dfs(int[] levels, int s, int t, int low) {
    if (s == t) {
      return low;
    }

    int result = 0;
    for (int e : edgeLists[s]) {
      Edge edge = edges.get(e);
      if (edge.capacity != 0 && levels[edge.to] == levels[s] + 1) {
        int next = dfs(levels, edge.to, t, Math.min(low - result, edge.capacity));
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

  static class Edge {
    int from;
    int to;
    int capacity;

    Edge(int from, int to, int capacity) {
      this.from = from;
      this.to = to;
      this.capacity = capacity;
    }
  }
}
