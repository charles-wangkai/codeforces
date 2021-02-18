import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long x = sc.nextLong();

      System.out.println(solve(x) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(long x) {
    for (int a = 1; (long) a * a * a < x; ++a) {
      int b = (int) Math.round(Math.pow(x - (long) a * a * a, 1.0 / 3));
      if ((long) a * a * a + (long) b * b * b == x) {
        return true;
      }
    }

    return false;
  }
}
