import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long a = sc.nextLong();
      long b = sc.nextLong();
      long x = sc.nextLong();

      System.out.println(solve(a, b, x) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(long a, long b, long x) {
    return isMagic(x, Math.max(a, b), Math.min(a, b));
  }

  static boolean isMagic(long x, long a, long b) {
    if (x > a) {
      return false;
    }
    if (x == b) {
      return true;
    }
    if (b == 0) {
      return x == a;
    }
    if (x % b == a % b) {
      return true;
    }

    return isMagic(x, b, a % b);
  }
}