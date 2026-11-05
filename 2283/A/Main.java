import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int l = sc.nextInt();
      int r = sc.nextInt();

      System.out.println(solve(l, r));
    }

    sc.close();
  }

  static int solve(int l, int r) {
    if (Math.abs(l + r) <= 1) {
      return 0;
    }
    if (l > 0 || r < 0) {
      return r - l;
    }

    return Math.abs(l + r) - 1;
  }
}