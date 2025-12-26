import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] u = new int[m];
    int[] v = new int[m];
    int[] x = new int[m];
    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      u[i] = Integer.parseInt(st.nextToken());
      v[i] = Integer.parseInt(st.nextToken());
      x[i] = Integer.parseInt(st.nextToken());
    }
    int[] s = new int[k];
    int[] y = new int[k];
    for (int i = 0; i < k; ++i) {
      st = new StringTokenizer(br.readLine());
      s[i] = Integer.parseInt(st.nextToken());
      y[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solve(n, u, v, x, s, y));
  }

  static int solve(int n, int[] u, int[] v, int[] x, int[] s, int[] y) {
    int result = 0;

    int[] minTrainLengths = new int[n];
    Arrays.fill(minTrainLengths, Integer.MAX_VALUE);
    for (int i = 0; i < s.length; ++i) {
      if (minTrainLengths[s[i] - 1] != Integer.MAX_VALUE) {
        ++result;
      }

      minTrainLengths[s[i] - 1] = Math.min(minTrainLengths[s[i] - 1], y[i]);
    }

    PriorityQueue<Element> pq =
        new PriorityQueue<>(
            Comparator.comparing(Element::distance).thenComparing(Element::byTrain));
    for (int i = 0; i < minTrainLengths.length; ++i) {
      if (minTrainLengths[i] != Integer.MAX_VALUE) {
        pq.offer(new Element(i, minTrainLengths[i], true));
      }
    }

    long[] distances = new long[n];
    Arrays.fill(distances, -1);
    distances[0] = 0;

    @SuppressWarnings("unchecked")
    List<Integer>[] edgeLists = new List[n];
    for (int i = 0; i < edgeLists.length; ++i) {
      edgeLists[i] = new ArrayList<>();
    }
    for (int i = 0; i < u.length; ++i) {
      edgeLists[u[i] - 1].add(i);
      edgeLists[v[i] - 1].add(i);
    }

    for (int edge : edgeLists[0]) {
      int other = (u[edge] - 1 == 0) ? (v[edge] - 1) : (u[edge] - 1);
      pq.offer(new Element(other, x[edge], false));
    }

    while (!pq.isEmpty()) {
      Element head = pq.poll();
      if (distances[head.node()] == -1) {
        distances[head.node()] = head.distance();

        for (int edge : edgeLists[head.node()]) {
          int other = (u[edge] - 1 == head.node()) ? (v[edge] - 1) : (u[edge] - 1);
          if (distances[other] == -1) {
            pq.offer(new Element(other, head.distance() + x[edge], false));
          }
        }
      } else if (head.byTrain()) {
        ++result;
      }
    }

    return result;
  }
}

record Element(int node, long distance, boolean byTrain) {}
