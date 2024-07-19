import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

  static String solve(int[][] a) {
    int n = a.length;
    int m = a[0].length;

    if (n == 1 && m == 1) {
      return "-1";
    }

    int[][] b = new int[n][m];
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        b[r][c] = (m == 1) ? a[(r + 1) % n][c] : a[r][(c + 1) % m];
      }
    }

    return IntStream.range(0, n)
        .mapToObj(
            r ->
                IntStream.range(0, m)
                    .map(c -> b[r][c])
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
  }
}