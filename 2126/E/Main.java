import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }
      int[] s = new int[n];
      for (int i = 0; i < s.length; ++i) {
        s[i] = sc.nextInt();
      }

      System.out.println(solve(p, s) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] p, int[] s) {
    long[] values = IntStream.range(0, p.length).mapToLong(i -> lcm(p[i], s[i])).toArray();

    long leftGcd = -1;
    for (int i = 0; i < p.length; ++i) {
      leftGcd = (leftGcd == -1) ? values[i] : gcd(leftGcd, values[i]);
      if (leftGcd != p[i]) {
        return false;
      }
    }

    long rightGcd = -1;
    for (int i = s.length - 1; i >= 0; --i) {
      rightGcd = (rightGcd == -1) ? values[i] : gcd(rightGcd, values[i]);
      if (rightGcd != s[i]) {
        return false;
      }
    }

    return true;
  }

  static long lcm(int x, int y) {
    return x / gcd(x, y) * y;
  }

  static long gcd(long x, long y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}