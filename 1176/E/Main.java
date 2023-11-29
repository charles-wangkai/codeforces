import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < t; ++tc) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int[] v = new int[m];
      int[] u = new int[m];
      for (int i = 0; i < m; ++i) {
        st = new StringTokenizer(br.readLine());
        v[i] = Integer.parseInt(st.nextToken());
        u[i] = Integer.parseInt(st.nextToken());
      }

      System.out.println(solve(n, v, u));
    }
  }

  static String solve(int n, int[] v, int[] u) {
    @SuppressWarnings("unchecked")
    Set<Integer>[] adjSets = new Set[n];
    for (int i = 0; i < adjSets.length; ++i) {
      adjSets[i] = new HashSet<>();
    }
    for (int i = 0; i < v.length; ++i) {
      adjSets[v[i] - 1].add(u[i] - 1);
      adjSets[u[i] - 1].add(v[i] - 1);
    }

    Queue<Integer> oneDegreeNodes = new ArrayDeque<>();
    for (int i = 0; i < adjSets.length; ++i) {
      if (adjSets[i].size() == 1) {
        oneDegreeNodes.offer(i);
      }
    }

    List<Integer> chosen = new ArrayList<>();
    boolean[] removed = new boolean[n];
    int index = 0;
    while (true) {
      while (index != removed.length && removed[index]) {
        ++index;
      }
      if (index == removed.length) {
        break;
      }

      while (!oneDegreeNodes.isEmpty()
          && (removed[oneDegreeNodes.peek()] || adjSets[oneDegreeNodes.peek()].size() != 1)) {
        oneDegreeNodes.poll();
      }

      if (oneDegreeNodes.isEmpty()) {
        chosen.add(index);
        remove(adjSets, oneDegreeNodes, removed, index);

        int adj = adjSets[index].iterator().next();
        remove(adjSets, oneDegreeNodes, removed, adj);
      } else {
        int node = adjSets[oneDegreeNodes.poll()].iterator().next();
        chosen.add(node);
        remove(adjSets, oneDegreeNodes, removed, node);
      }
    }

    return String.format(
        "%d\n%s",
        chosen.size(),
        chosen.stream()
            .map(node -> node + 1)
            .map(String::valueOf)
            .collect(Collectors.joining(" ")));
  }

  static void remove(
      Set<Integer>[] adjSets, Queue<Integer> oneDegreeNodes, boolean[] removed, int node) {
    for (int adj : adjSets[node]) {
      adjSets[adj].remove(node);

      if (adjSets[adj].isEmpty()) {
        removed[adj] = true;
      } else if (adjSets[adj].size() == 1) {
        oneDegreeNodes.offer(adj);
      }
    }

    removed[node] = true;
  }
}