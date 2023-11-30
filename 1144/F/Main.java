import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] u = new int[m];
    int[] v = new int[m];
    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      u[i] = Integer.parseInt(st.nextToken());
      v[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solve(n, u, v));
  }

  static String solve(int n, int[] u, int[] v) {
    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[n];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < u.length; ++i) {
      adjLists[u[i] - 1].add(v[i] - 1);
      adjLists[v[i] - 1].add(u[i] - 1);
    }

    int[] colors = new int[n];
    for (int i = 0; i < n; ++i) {
      if (colors[i] == 0 && !search(adjLists, colors, i, 1)) {
        return "NO";
      }
    }

    return String.format(
        "YES\n%s",
        Arrays.stream(u)
            .map(ui -> (colors[ui - 1] == 1) ? 0 : 1)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining()));
  }

  static boolean search(List<Integer>[] adjLists, int[] colors, int node, int color) {
    colors[node] = color;

    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(node);

    while (!queue.isEmpty()) {
      int head = queue.poll();
      for (int adj : adjLists[head]) {
        if (colors[adj] == 0) {
          colors[adj] = -colors[head];
          queue.offer(adj);
        } else if (colors[adj] != -colors[head]) {
          return false;
        }
      }
    }

    return true;
  }
}