import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long p = sc.nextLong();
      long a = sc.nextLong();
      long b = sc.nextLong();
      long c = sc.nextLong();

      System.out.println(solve(p, a, b, c));
    }

    sc.close();
  }

  static long solve(long p, long a, long b, long c) {
    return Math.min(Math.min(computeWaitTime(p, a), computeWaitTime(p, b)), computeWaitTime(p, c));
  }

  static long computeWaitTime(long p, long x) {
    return (x - p % x) % x;
  }
}
