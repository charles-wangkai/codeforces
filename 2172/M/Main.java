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
    int k = Integer.parseInt(st.nextToken());
    int[] a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < a.length; ++i) {
      a[i] = Integer.parseInt(st.nextToken());
    }
    int[] u = new int[m];
    int[] v = new int[m];
    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      u[i] = Integer.parseInt(st.nextToken());
      v[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solve(a, u, v, k));
  }

  static String solve(int[] a, int[] u, int[] v, int k) {
    int n = a.length;

    @SuppressWarnings("unchecked")
    List<Integer>[] adjLists = new List[n];
    for (int i = 0; i < adjLists.length; ++i) {
      adjLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < u.length; ++i) {
      adjLists[u[i] - 1].add(v[i] - 1);
      adjLists[v[i] - 1].add(u[i] - 1);
    }

    int[] distances = new int[n];
    Arrays.fill(distances, -1);
    distances[0] = 0;

    Queue<Integer> queue = new ArrayDeque<>();
    queue.offer(0);

    int[] result = new int[k];
    while (!queue.isEmpty()) {
      int head = queue.poll();
      for (int adj : adjLists[head]) {
        if (distances[adj] == -1) {
          distances[adj] = distances[head] + 1;
          queue.offer(adj);

          result[a[adj] - 1] = Math.max(result[a[adj] - 1], distances[adj]);
        }
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}