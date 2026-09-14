import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(n, k));
    }

    sc.close();
  }

  static String solve(int n, int k) {
    if (k < n || k > 2 * n - 1) {
      return "-1";
    }

    int[][] result = new int[n][n];
    for (int i = 0; i < n; ++i) {
      result[i][i] = i + 1;
    }

    int value = n + 1;
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < n; ++c) {
        if (result[r][c] == 0) {
          result[r][c] = value;
          ++value;
        }
      }
    }

    for (int i = 0; i < k - n; ++i) {
      int temp = result[i + 1][i + 1];
      result[i + 1][i + 1] = result[i + 1][0];
      result[i + 1][0] = temp;
    }

    return Arrays.stream(result)
        .map(line -> Arrays.stream(line).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
  }
}