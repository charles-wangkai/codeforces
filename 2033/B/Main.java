import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[][] a = new int[n][n];
      for (int r = 0; r < n; ++r) {
        for (int c = 0; c < n; ++c) {
          a[r][c] = sc.nextInt();
        }
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[][] a) {
    int n = a.length;

    Map<Integer, Integer> rcDiffToMinValue = new HashMap<>();
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < n; ++c) {
        rcDiffToMinValue.put(
            r - c, Math.min(rcDiffToMinValue.getOrDefault(r - c, Integer.MAX_VALUE), a[r][c]));
      }
    }

    return -rcDiffToMinValue.values().stream()
        .filter(minValue -> minValue < 0)
        .mapToInt(Integer::intValue)
        .sum();
  }
}