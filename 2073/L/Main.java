import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
  static final int[] R_OFFSETS = {-1, 0, 1, 0};
  static final int[] C_OFFSETS = {0, 1, 0, -1};

  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int row = Integer.parseInt(st.nextToken());
    int col = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    int p = Integer.parseInt(st.nextToken());
    int[][] G = new int[row][col];
    for (int r = 0; r < row; ++r) {
      st = new StringTokenizer(br.readLine());
      for (int c = 0; c < col; ++c) {
        G[r][c] = Integer.parseInt(st.nextToken());
      }
    }

    System.out.println(solve(G, n, p));
  }

  static String solve(int[][] G, int n, int p) {
    int row = G.length;
    int col = G[0].length;

    Set<Integer> adjs = new HashSet<>();
    for (int r = 0; r < row; ++r) {
      for (int c = 0; c < col; ++c) {
        if (G[r][c] != 0) {
          for (int i = 0; i < R_OFFSETS.length; ++i) {
            int adjR = r + R_OFFSETS[i];
            int adjC = c + C_OFFSETS[i];
            if (adjR >= 0 && adjR < row && adjC >= 0 && adjC < col && G[adjR][adjC] != 0) {
              addAdj(n, p, adjs, G[r][c], G[adjR][adjC]);
              addAdj(n, p, adjs, G[adjR][adjC], G[r][c]);
            }
          }
        }
      }
    }

    return "%d/%d".formatted(adjs.size(), n - 1);
  }

  static void addAdj(int n, int p, Set<Integer> adjs, int node, int other) {
    if (node <= p) {
      int adj = other + (p - node);
      if (adj <= n) {
        adjs.add(adj);
      }
    }
  }
}
