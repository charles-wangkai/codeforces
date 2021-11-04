import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long x0 = sc.nextLong();
      long n = sc.nextLong();

      System.out.println(solve(x0, n));
    }

    sc.close();
  }

  static long solve(long x0, long n) {
    long result = x0;
    for (long i = (n - 1) / 4 * 4 + 1; i <= n; ++i) {
      if (result % 2 == 0) {
        result -= i;
      } else {
        result += i;
      }
    }

    return result;
  }
}
