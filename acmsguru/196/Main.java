import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    Edge[] edges = new Edge[M];
    for (int i = 0; i < edges.length; ++i) {
      st = new StringTokenizer(br.readLine());
      int v1 = Integer.parseInt(st.nextToken()) - 1;
      int v2 = Integer.parseInt(st.nextToken()) - 1;

      edges[i] = new Edge(v1, v2);
    }

    System.out.println(solve(N, edges));
  }

  static long solve(int N, Edge[] edges) {
    int[] counts = new int[N];
    for (Edge edge : edges) {
      ++counts[edge.v1];
      ++counts[edge.v2];
    }

    return Arrays.stream(counts).mapToLong(x -> (long) x * x).sum();
  }
}

class Edge {
  int v1;
  int v2;

  Edge(int v1, int v2) {
    this.v1 = v1;
    this.v2 = v2;
  }
}
