import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] a = new int[m];
    int[] b = new int[m];
    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      a[i] = Integer.parseInt(st.nextToken());
      b[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solve(n, a, b));
  }

  static int solve(int n, int[] a, int[] b) {
    boolean[][] adjacents = new boolean[n][n];
    int[] adjCounts = new int[n];
    for (int i = 0; i < a.length; ++i) {
      adjacents[a[i] - 1][b[i] - 1] = true;
      adjacents[b[i] - 1][a[i] - 1] = true;

      ++adjCounts[a[i] - 1];
      ++adjCounts[b[i] - 1];
    }

    int result = Integer.MAX_VALUE;
    for (int i = 0; i < a.length; ++i) {
      for (int j = i + 1; j < a.length; ++j) {
        int[] nodes = buildNodes(a[i] - 1, b[i] - 1, a[j] - 1, b[j] - 1);
        if (nodes != null
            && adjacents[nodes[0]][nodes[1]]
            && adjacents[nodes[1]][nodes[2]]
            && adjacents[nodes[2]][nodes[0]]) {
          result =
              Math.min(result, adjCounts[nodes[0]] + adjCounts[nodes[1]] + adjCounts[nodes[2]] - 6);
        }
      }
    }

    return (result == Integer.MAX_VALUE) ? -1 : result;
  }

  static int[] buildNodes(int p, int q, int r, int s) {
    if (allDifferent(p, q, r) && sameToOne(s, p, q, r)) {
      return new int[] {p, q, r};
    }
    if (allDifferent(p, q, s) && sameToOne(r, p, q, s)) {
      return new int[] {p, q, s};
    }
    if (allDifferent(p, r, s) && sameToOne(q, p, r, s)) {
      return new int[] {p, r, s};
    }
    if (allDifferent(q, r, s) && sameToOne(p, q, r, s)) {
      return new int[] {q, r, s};
    }

    return null;
  }

  static boolean allDifferent(int x, int y, int z) {
    return x != y && y != z && z != x;
  }

  static boolean sameToOne(int p, int x, int y, int z) {
    return p == x || p == y || p == z;
  }
}