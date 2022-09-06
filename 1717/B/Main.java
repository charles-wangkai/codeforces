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
      int r = sc.nextInt() - 1;
      int c = sc.nextInt() - 1;

      System.out.println(solve(n, k, r, c));
    }

    sc.close();
  }

  static String solve(int n, int k, int r, int c) {
    char[][] result = new char[n][n];
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        result[i][j] = ((i + j) % k == (r + c) % k) ? 'X' : '.';
      }
    }

    return Arrays.stream(result).map(String::new).collect(Collectors.joining("\n"));
  }
}