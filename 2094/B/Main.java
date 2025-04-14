import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int l = sc.nextInt();
      int r = sc.nextInt();

      System.out.println(solve(n, m, l, r));
    }

    sc.close();
  }

  static String solve(int n, int m, int l, int r) {
    int rest = n - m;

    int leftDelta = Math.min(rest, -l);
    l += leftDelta;

    r -= rest - leftDelta;

    return "%d %d".formatted(l, r);
  }
}