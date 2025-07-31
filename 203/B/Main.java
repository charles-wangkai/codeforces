import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static final int SIZE = 3;

  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] x = new int[m];
    int[] y = new int[m];
    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      x[i] = Integer.parseInt(st.nextToken());
      y[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solve(n, x, y));
  }

  static int solve(int n, int[] x, int[] y) {
    boolean[][] painted = new boolean[n][n];
    for (int i = 0; i < x.length; ++i) {
      painted[x[i] - 1][y[i] - 1] = true;

      if (check(painted, x[i] - 1, y[i] - 1)) {
        return i + 1;
      }
    }

    return -1;
  }

  static boolean check(boolean[][] painted, int r, int c) {
    for (int beginR = r - SIZE + 1; beginR <= r; ++beginR) {
      for (int beginC = c - SIZE + 1; beginC <= c; ++beginC) {
        if (isAllPainted(painted, beginR, beginC)) {
          return true;
        }
      }
    }

    return false;
  }

  static boolean isAllPainted(boolean[][] painted, int beginR, int beginC) {
    for (int dx = 0; dx < SIZE; ++dx) {
      for (int dy = 0; dy < SIZE; ++dy) {
        if (!isPainted(painted, beginR + dx, beginC + dy)) {
          return false;
        }
      }
    }

    return true;
  }

  static boolean isPainted(boolean[][] painted, int r, int c) {
    return r >= 0 && r < painted.length && c >= 0 && c < painted[r].length && painted[r][c];
  }
}
