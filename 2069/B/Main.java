import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int[] R_OFFSETS = {-1, 0, 1, 0};
  static final int[] C_OFFSETS = {0, 1, 0, -1};

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

  static int solve(int[][] a) {
    int n = a.length;
    int m = a[0].length;

    Map<Integer, Boolean> colorToHasAdj = new HashMap<>();
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        colorToHasAdj.put(a[r][c], false);
      }
    }
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        if (hasAdj(a, r, c)) {
          colorToHasAdj.put(a[r][c], true);
        }
      }
    }

    int[] steps = colorToHasAdj.values().stream().mapToInt(hasAdj -> hasAdj ? 2 : 1).toArray();

    return Arrays.stream(steps).sum() - Arrays.stream(steps).max().getAsInt();
  }

  static boolean hasAdj(int[][] a, int r, int c) {
    int n = a.length;
    int m = a[0].length;

    return IntStream.range(0, R_OFFSETS.length)
        .anyMatch(
            i -> {
              int adjR = r + R_OFFSETS[i];
              int adjC = c + C_OFFSETS[i];

              return adjR >= 0 && adjR < n && adjC >= 0 && adjC < m && a[adjR][adjC] == a[r][c];
            });
  }
}