import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static String solve(int n) {
    if (n == 2) {
      return "-1";
    }

    int[][] matrix = new int[n][n];
    matrix[0][0] = n * n;
    matrix[n - 1][n - 1] = 1;

    int beginR = 1;
    int beginC = 0;
    int r = beginR;
    int c = beginC;
    for (int i = 2; i <= n * n - 1; ++i) {
      matrix[r][c] = i;

      --r;
      ++c;
      if (r == -1 || c == n) {
        if (beginR == n - 1) {
          ++beginC;
        } else {
          ++beginR;
        }

        r = beginR;
        c = beginC;
      }
    }

    return Arrays.stream(matrix)
        .map(row -> Arrays.stream(row).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
  }
}
