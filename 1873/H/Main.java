import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();
      int[] u = new int[n];
      int[] v = new int[n];
      for (int i = 0; i < n; ++i) {
        u[i] = sc.nextInt();
        v[i] = sc.nextInt();
      }

      System.out.println(solve(u, v, a, b) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] u, int[] v, int a, int b) {
    int n = u.length;

    int node1 = -1;
    int node2 = -1;
    Dsu dsu = new Dsu(n);
    for (int i = 0; i < u.length; ++i) {
      int leader1 = dsu.find(u[i] - 1);
      int leader2 = dsu.find(v[i] - 1);
      if (leader1 == leader2) {
        node1 = u[i] - 1;
        node2 = v[i] - 1;
      } else {
        dsu.union(leader1, leader2);
      }
    }

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[n];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < u.length; ++i) {
      adjLists[u[i] - 1].add(v[i] - 1);
      adjLists[v[i] - 1].add(u[i] - 1);
    }

    int[] distances =
        buildDistances(
            adjLists,
            findEntrance(
                adjLists, search(adjLists, node2, new ArrayList<>(), node2, node1), b - 1));

    return distances[b - 1] < distances[a - 1];
  }

  static int findEntrance(List<Integer>[] adjLists, List<Integer> cycle, int start) {
    int[] distances = buildDistances(adjLists, start);

    return cycle.stream().min(Comparator.comparing(node -> distances[node])).get();
  }

  static int[] buildDistances(List<Integer>[] adjLists, int start) {
    int n = adjLists.length;

    int[] distances = new int[n];
    Arrays.fill(distances, -1);
    distances[start] = 0;

    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(start);

    while (!queue.isEmpty()) {
      int head = queue.poll();
      for (int adj : adjLists[head]) {
        if (distances[adj] == -1) {
          distances[adj] = distances[head] + 1;
          queue.offer(adj);
        }
      }
    }

    return distances;
  }

  static List<Integer> search(
      List<Integer>[] adjLists, int target, List<Integer> path, int parent, int node) {
    path.add(node);

    if (node == target) {
      return path;
    }

    for (int adj : adjLists[node]) {
      if (adj != parent) {
        List<Integer> p = search(adjLists, target, path, node, adj);
        if (p != null) {
          return p;
        }
      }
    }

    path.removeLast();

    return null;
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