import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long p = sc.nextLong();
      int q = sc.nextInt();

      System.out.println(solve(p, q));
    }

    sc.close();
  }

  static long solve(long p, int q) {
    if (p % q != 0) {
      return p;
    }

    long result = 0;
    for (int i = 2; i * i <= q; ++i) {
      if (q % i == 0) {
        int exponent = 0;
        while (q % i == 0) {
          ++exponent;
          q /= i;
        }

        long x = p;
        while (x % i == 0) {
          x /= i;
        }
        for (int j = 0; j < exponent - 1; ++j) {
          x *= i;
        }
        result = Math.max(result, x);
      }
    }
    if (q != 1) {
      long x = p;
      while (x % q == 0) {
        x /= q;
      }

      result = Math.max(result, x);
    }

    return result;
  }
}