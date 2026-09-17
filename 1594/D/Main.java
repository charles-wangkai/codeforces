import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < t; ++tc) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int[] u = new int[m];
      int[] v = new int[m];
      String[] c = new String[m];
      for (int i = 0; i < m; ++i) {
        st = new StringTokenizer(br.readLine());
        u[i] = Integer.parseInt(st.nextToken());
        v[i] = Integer.parseInt(st.nextToken());
        c[i] = st.nextToken();
      }

      System.out.println(solve(n, u, v, c));
    }
  }

  static int solve(int n, int[] u, int[] v, String[] c) {
    @SuppressWarnings("unchecked")
    List<Integer>[] edgeLists = new List[n];
    for (int i = 0; i < edgeLists.length; ++i) {
      edgeLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < u.length; ++i) {
      edgeLists[u[i] - 1].add(i);
      edgeLists[v[i] - 1].add(i);
    }

    int result = 0;
    boolean[] visited = new boolean[n];
    for (int i = 0; i < visited.length; ++i) {
      if (!visited[i]) {
        Map<Integer, Boolean> nodeToIsBlack = new HashMap<>();
        if (!search(u, v, c, edgeLists, nodeToIsBlack, i, true)) {
          return -1;
        }

        result +=
            Math.max(
                nodeToIsBlack.values().stream().filter(isBlack -> !isBlack).count(),
                nodeToIsBlack.values().stream().filter(isBlack -> isBlack).count());

        for (int node : nodeToIsBlack.keySet()) {
          visited[node] = true;
        }
      }
    }

    return result;
  }

  static boolean search(
      int[] u,
      int[] v,
      String[] c,
      List<Integer>[] edgeLists,
      Map<Integer, Boolean> nodeToIsBlack,
      int node,
      boolean isBlack) {
    if (nodeToIsBlack.containsKey(node)) {
      return nodeToIsBlack.get(node) == isBlack;
    }

    nodeToIsBlack.put(node, isBlack);

    for (int edge : edgeLists[node]) {
      int adj = (u[edge] - 1 == node) ? (v[edge] - 1) : (u[edge] - 1);
      if (!search(
          u,
          v,
          c,
          edgeLists,
          nodeToIsBlack,
          adj,
          isBlack ^ (c[edge].equals("crewmate") ? false : true))) {
        return false;
      }
    }

    return true;
  }
}