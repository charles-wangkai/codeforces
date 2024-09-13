import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[][] a = new int[n][m];
      for (int r = 0; r < n; ++r) {
        for (int c = 0; c < m; ++c) {
          a[r][c] = sc.nextInt();
        }
      }
      int[][] b = new int[n][m];
      for (int r = 0; r < n; ++r) {
        for (int c = 0; c < m; ++c) {
          b[r][c] = sc.nextInt();
        }
      }

      System.out.println(solve(a, b) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[][] a, int[][] b) {
    int n = a.length;
    int m = a[0].length;

    Map<Integer, Integer> valueToOldR = new HashMap<>();
    Map<Integer, Integer> valueToOldC = new HashMap<>();
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        valueToOldR.put(a[r][c], r);
        valueToOldC.put(a[r][c], c);
      }
    }

    Map<Integer, Integer> rMapping = new HashMap<>();
    for (int r = 0; r < n; ++r) {
      if (rMapping.containsKey(valueToOldR.get(b[r][0]))) {
        return false;
      }

      rMapping.put(valueToOldR.get(b[r][0]), r);
    }

    Map<Integer, Integer> cMapping = new HashMap<>();
    for (int c = 0; c < m; ++c) {
      if (cMapping.containsKey(valueToOldC.get(b[0][c]))) {
        return false;
      }

      cMapping.put(valueToOldC.get(b[0][c]), c);
    }

    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        if (b[rMapping.get(r)][cMapping.get(c)] != a[r][c]) {
          return false;
        }
      }
    }

    return true;
  }
}