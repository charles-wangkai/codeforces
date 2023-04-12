import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < t; ++tc) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      int[][] a = new int[n][n];
      for (int r = 0; r < n; ++r) {
        st = new StringTokenizer(br.readLine());
        for (int c = 0; c < n; ++c) {
          a[r][c] = Integer.parseInt(st.nextToken());
        }
      }

      System.out.println(solve(a, k) ? "YES" : "NO");
    }
  }

  static boolean solve(int[][] a, int k) {
    int n = a.length;

    int needed = 0;
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < n; ++c) {
        if (a[r][c] != a[n - 1 - r][n - 1 - c]) {
          ++needed;
        }
      }
    }
    needed /= 2;

    return k >= needed && (n % 2 == 1 || (k - needed) % 2 == 0);
  }
}
