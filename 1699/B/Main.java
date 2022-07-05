import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();

      System.out.println(solve(n, m));
    }

    sc.close();
  }

  static String solve(int n, int m) {
    int[][] result = new int[n][m];

    for (int r = 0; r < n; r += 2) {
      for (int c = 0; c < m; c += 2) {
        if (r % 4 == c % 4) {
          result[r][c] = 1;
          result[r + 1][c + 1] = 1;
        } else {
          result[r + 1][c] = 1;
          result[r][c + 1] = 1;
        }
      }
    }

    return Arrays.stream(result)
        .map(line -> Arrays.stream(line).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
  }
}