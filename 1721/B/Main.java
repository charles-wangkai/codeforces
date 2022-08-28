import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int sx = sc.nextInt() - 1;
      int sy = sc.nextInt() - 1;
      int d = sc.nextInt();

      System.out.println(solve(n, m, sx, sy, d));
    }

    sc.close();
  }

  static int solve(int n, int m, int sx, int sy, int d) {
    boolean upBlocked = sx - d <= 0;
    boolean downBlocked = sx + d >= n - 1;
    boolean leftBlocked = sy - d <= 0;
    boolean rightBlocked = sy + d >= m - 1;

    return ((upBlocked && leftBlocked)
            || (downBlocked && rightBlocked)
            || (upBlocked && downBlocked)
            || (leftBlocked && rightBlocked))
        ? -1
        : (n + m - 2);
  }
}