import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int p = sc.nextInt();

      System.out.println(solve(n, p));
    }

    sc.close();
  }

  static String solve(int n, int p) {
    boolean[][] edges = new boolean[n][n];
    int rest = 2 * n + p;
    for (int a = 0; a < n; ++a) {
      for (int b = a + 1; b < n; ++b) {
        if (a <= 1 || b <= 4) {
          edges[a][b] = true;
          --rest;
        }
      }
    }
    for (int a = 0; a < n; ++a) {
      for (int b = a + 1; b < n; ++b) {
        if (!edges[a][b] && rest != 0) {
          edges[a][b] = true;
          --rest;
        }
      }
    }

    List<String> result = new ArrayList<>();
    for (int a = 0; a < n; ++a) {
      for (int b = a + 1; b < n; ++b) {
        if (edges[a][b]) {
          result.add("%d %d".formatted(a + 1, b + 1));
        }
      }
    }

    return String.join("\n", result);
  }
}