import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int q = sc.nextInt();
      int d = sc.nextInt();
      for (int i = 0; i < q; ++i) {
        int ai = sc.nextInt();

        System.out.println(solve(ai, d) ? "YES" : "NO");
      }
    }

    sc.close();
  }

  static boolean solve(int ai, int d) {
    if (ai >= d * 10) {
      return true;
    }

    while (ai > 0) {
      if (isLucky(ai, d)) {
        return true;
      }

      ai -= d;
    }

    return false;
  }

  static boolean isLucky(int x, int d) {
    return String.valueOf(x).chars().anyMatch(ch -> ch - '0' == d);
  }
}
