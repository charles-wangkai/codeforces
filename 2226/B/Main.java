import java.util.Scanner;

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

      System.out.println(solve(p));
    }

    sc.close();
  }

  static int solve(int[] p) {
    int result = 0;
    for (int i = 0; i < p.length; ++i) {
      int min = p[i];
      int max = p[i];
      int g = p[i];
      for (int j = i + 1; j < p.length; ++j) {
        min = Math.min(min, p[j]);
        max = Math.max(max, p[j]);
        g = gcd(g, p[j]);

        if (max - min > g) {
          break;
        }
        if (max - min == g) {
          ++result;
        }
      }
    }

    return result;
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}