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
    int[][] square = new int[n][n];
    for (int i = 0; i < n; ++i) {
      square[i][i] = 1;
      square[i][n - 1 - i] = 1;
    }

    if (n % 2 != 0) {
      for (int i = -1; i <= 1; ++i) {
        for (int j = -1; j <= 1; ++j) {
          square[n / 2 + i][n / 2 + j] = 1;
        }
      }
    }

    return Arrays.stream(square)
        .map(row -> Arrays.stream(row).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
  }
}
