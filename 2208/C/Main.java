import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] c = new int[n];
      int[] p = new int[n];
      for (int i = 0; i < n; ++i) {
        c[i] = sc.nextInt();
        p[i] = sc.nextInt();
      }

      System.out.println("%.9f".formatted(solve(c, p)));
    }

    sc.close();
  }

  static double solve(int[] c, int[] p) {
    double result = 0;
    for (int i = c.length - 1; i >= 0; --i) {
      result = Math.max(result, c[i] + (1 - p[i] / 100.0) * result);
    }

    return result;
  }
}