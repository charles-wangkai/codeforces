import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[][] G = new int[n][n];
      for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
          G[i][j] = sc.nextInt();
        }
      }

      System.out.println(solve(G));
    }

    sc.close();
  }

  static String solve(int[][] G) {
    int n = G.length;

    int[] result = new int[2 * n];
    for (int i = 1; i <= n; ++i) {
      result[i] = G[0][i - 1];
    }
    for (int i = n + 1; i < result.length; ++i) {
      result[i] = G[i - n][n - 1];
    }
    result[0] = 2 * n * (2 * n + 1) / 2 - Arrays.stream(result).sum();

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}