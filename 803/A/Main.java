import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();

    System.out.println(solve(n, k));

    sc.close();
  }

  static String solve(int n, int k) {
    if (k > n * n) {
      return "-1";
    }

    int[][] result = new int[n][n];
    for (int r = 0; r < n; ++r) {
      for (int c = r; c < n; ++c) {
        if (c == r) {
          if (k >= 1) {
            result[r][c] = 1;
            --k;
          }
        } else if (k >= 2) {
          result[r][c] = 1;
          result[c][r] = 1;
          k -= 2;
        }
      }
    }

    return Arrays.stream(result)
        .map(line -> Arrays.stream(line).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
  }
}