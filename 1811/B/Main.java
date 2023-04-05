import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x1 = sc.nextInt();
      int y1 = sc.nextInt();
      int x2 = sc.nextInt();
      int y2 = sc.nextInt();

      System.out.println(solve(n, x1, y1, x2, y2));
    }

    sc.close();
  }

  static int solve(int n, int x1, int y1, int x2, int y2) {
    return Math.abs(computeCentralDistance(n, x1, y1) - computeCentralDistance(n, x2, y2));
  }

  static int computeCentralDistance(int n, int x, int y) {
    int result = Integer.MAX_VALUE;
    for (int cx = n / 2; cx <= n / 2 + 1; ++cx) {
      for (int cy = n / 2; cy <= n / 2 + 1; ++cy) {
        result = Math.min(result, Math.max(Math.abs(x - cx), Math.abs(y - cy)));
      }
    }

    return result;
  }
}
