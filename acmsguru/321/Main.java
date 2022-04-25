import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int[] u = new int[N - 1];
    int[] v = new int[N - 1];
    boolean[] p = new boolean[N - 1];
    for (int i = 0; i < N - 1; ++i) {
      st = new StringTokenizer(br.readLine());
      u[i] = Integer.parseInt(st.nextToken()) - 1;
      v[i] = Integer.parseInt(st.nextToken()) - 1;
      p[i] = st.nextToken().equals("protected");
    }

    System.out.println(solve(u, v, p));
  }

  static String solve(int[] u, int[] v, boolean[] p) {
    int N = u.length + 1;

    @SuppressWarnings("unchecked")
    List<Integer>[] edgeLists = new List[N];
    for (int i = 0; i < edgeLists.length; ++i) {
      edgeLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < u.length; ++i) {
      edgeLists[v[i]].add(i);
    }

    int[] edges = new int[N];
    for (int i = 0; i < u.length; ++i) {
      edges[u[i]] = i;
    }

    List<Integer> converted = new ArrayList<>();
    search(u, v, p, edgeLists, edges, converted, new ArrayDeque<>(), new ArrayList<>(), 1, 0);

    return String.format(
        "%d\n%s",
        converted.size(), converted.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }

  static void search(
      int[] u,
      int[] v,
      boolean[] p,
      List<Integer>[] edgeLists,
      int[] edges,
      List<Integer> converted,
      ArrayDeque<Integer> candidates,
      List<Integer> path,
      int depth,
      int node) {
    for (int edge : edgeLists[node]) {
      if (!p[edge]) {
        candidates.offerLast(u[edge]);
      }

      if (depth < candidates.size() * 2) {
        int head = candidates.pollFirst();
        p[edges[head]] = true;
        converted.add(edges[head] + 1);
      }

      path.add(u[edge]);

      search(u, v, p, edgeLists, edges, converted, candidates, path, depth + 1, u[edge]);

      path.remove(path.size() - 1);
      if (!candidates.isEmpty() && candidates.peekLast() == u[edge]) {
        candidates.pollLast();
      }
    }
  }
}