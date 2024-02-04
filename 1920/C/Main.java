import java.util.Scanner;

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

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[] a) {
    int n = a.length;

    int result = 0;
    for (int i = 1; i * i <= n; ++i) {
      if (n % i == 0) {
        if (check(a, i)) {
          ++result;
        }
        if (i * i != n && check(a, n / i)) {
          ++result;
        }
      }
    }

    return result;
  }

  static boolean check(int[] a, int k) {
    int g = -1;
    for (int i = 0; i + k < a.length; ++i) {
      if (a[i] != a[i + k]) {
        if (g == -1) {
          g = Math.abs(a[i] - a[i + k]);
        } else {
          g = gcd(g, Math.abs(a[i] - a[i + k]));
        }
      }

      if (g == 1) {
        return false;
      }
    }

    return true;
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}