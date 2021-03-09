import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

      System.out.println(solve(a));
    }

    sc.close();
  }

  static long solve(int[][] a) {
    int n = a.length;
    int m = a[0].length;

    long result = 0;
    for (int r = 0; r * 2 < n; ++r) {
      for (int c = 0; c * 2 < m; ++c) {
        List<Integer> related = new ArrayList<>();
        related.add(a[r][c]);
        related.add(a[n - 1 - r][m - 1 - c]);
        if (r != n - 1 - r && c != m - 1 - c) {
          related.add(a[n - 1 - r][c]);
          related.add(a[r][m - 1 - c]);
        }
        Collections.sort(related);

        for (int i = 0; i < related.size(); ++i) {
          if (i * 2 < related.size()) {
            result -= related.get(i);
          } else {
            result += related.get(i);
          }
        }
      }
    }

    return result;
  }
}
