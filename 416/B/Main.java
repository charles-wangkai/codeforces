import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int m = sc.nextInt();
    int n = sc.nextInt();
    int[][] t = new int[m][n];
    for (int r = 0; r < m; ++r) {
      for (int c = 0; c < n; ++c) {
        t[r][c] = sc.nextInt();
      }
    }

    System.out.println(solve(t));

    sc.close();
  }

  static String solve(int[][] t) {
    int m = t.length;
    int n = t[0].length;

    int[][] endTimes = new int[m][n];
    for (int r = 0; r < m; ++r) {
      for (int c = 0; c < n; ++c) {
        endTimes[r][c] =
            Math.max((r == 0) ? 0 : endTimes[r - 1][c], (c == 0) ? 0 : endTimes[r][c - 1])
                + t[r][c];
      }
    }

    return IntStream.range(0, m)
        .map(r -> endTimes[r][n - 1])
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}