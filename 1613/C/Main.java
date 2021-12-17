import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      long h = sc.nextLong();
      long[] a = new long[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextLong();
      }

      System.out.println(solve(a, h));
    }

    sc.close();
  }

  static long solve(long[] a, long h) {
    long result = -1;
    long lower = 1;
    long upper = h;
    while (lower <= upper) {
      long middle = (lower + upper) / 2;
      if (check(a, h, middle)) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static boolean check(long[] a, long h, long k) {
    long rest = h;
    for (int i = 0; i < a.length; ++i) {
      if (i == a.length - 1) {
        rest -= k;
      } else {
        rest -= Math.min(a[i + 1] - a[i], k);
      }

      if (rest <= 0) {
        return true;
      }
    }

    return false;
  }
}
