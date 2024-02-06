import java.util.Scanner;

public class Main {
  static final int BIT_NUM = 60;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long a = sc.nextLong();
      long b = sc.nextLong();
      long r = sc.nextLong();

      System.out.println(solve(a, b, r));
    }

    sc.close();
  }

  static long solve(long a, long b, long r) {
    long x = 0;
    long diff = 0;
    for (int i = BIT_NUM - 1; i >= 0; --i) {
      long bitDiff = (a & (1L << i)) - (b & (1L << i));

      if (x + (1L << i) > r
          || bitDiff == 0
          || diff == 0
          || Long.signum(diff) == -Long.signum(bitDiff)) {
        diff += bitDiff;
      } else {
        diff -= bitDiff;
        x += 1L << i;
      }
    }

    return Math.abs(diff);
  }
}