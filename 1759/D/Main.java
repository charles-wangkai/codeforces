import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();

      System.out.println(solve(n, m));
    }

    sc.close();
  }

  static long solve(int n, int m) {
    int factor = 1;
    int exponentDiff = computeExponent(n, 2) - computeExponent(n, 5);
    while (true) {
      int f;
      if (exponentDiff < 0) {
        f = 2;
        ++exponentDiff;
      } else if (exponentDiff > 0) {
        f = 5;
        --exponentDiff;
      } else {
        f = 10;
      }

      if ((long) factor * f > m) {
        break;
      }

      factor *= f;
    }

    return (long) n * (m / factor * factor);
  }

  static int computeExponent(int n, int base) {
    int result = 0;
    while (n % base == 0) {
      ++result;
      n /= base;
    }

    return result;
  }
}
