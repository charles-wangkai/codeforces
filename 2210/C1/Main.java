import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static int solve(int[] a, int[] b) {
    int[] g = IntStream.range(0, a.length - 1).map(i -> gcd(a[i], a[i + 1])).toArray();
    int[] c =
        IntStream.range(0, a.length)
            .map(i -> (i == 0) ? g[0] : ((i == g.length) ? g[g.length - 1] : lcm(g[i - 1], g[i])))
            .toArray();

    return (int) IntStream.range(0, c.length).filter(i -> c[i] != a[i]).count();
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }

  static int lcm(int x, int y) {
    return x / gcd(x, y) * y;
  }
}