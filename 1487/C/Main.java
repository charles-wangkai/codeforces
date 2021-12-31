import java.util.Scanner;

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
    int[][] outcomes = new int[n][n];
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < (n - 1) / 2; ++j) {
        outcomes[i][(i + 1 + j) % n] = 1;
        outcomes[i][(i - 1 - j + n) % n] = -1;
      }
    }

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < n; ++i) {
      for (int j = i + 1; j < n; ++j) {
        if (result.length() != 0) {
          result.append(' ');
        }
        result.append(outcomes[i][j]);
      }
    }

    return result.toString();
  }
}
