import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

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

    sc.close();
  }

  static int solve(int[] a, int[] b) {
    int alwaysZeroCount = 0;
    Map<Rational, Integer> ratioToCount = new HashMap<>();
    for (int i = 0; i < a.length; ++i) {
      if (a[i] == 0) {
        if (b[i] == 0) {
          ++alwaysZeroCount;
        }
      } else {
        int g = gcd(a[i], b[i]);
        int numer = a[i] / g;
        int denom = b[i] / g;
        if (numer < 0) {
          numer *= -1;
          denom *= -1;
        }

        Rational ratio = new Rational(numer, denom);
        ratioToCount.put(ratio, ratioToCount.getOrDefault(ratio, 0) + 1);
      }
    }

    return ratioToCount.values().stream().mapToInt(Integer::intValue).max().orElse(0)
        + alwaysZeroCount;
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}

record Rational(int numer, int denom) {}
