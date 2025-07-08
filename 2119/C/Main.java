import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long n = sc.nextLong();
      long l = sc.nextLong();
      long r = sc.nextLong();
      long k = sc.nextLong();

      System.out.println(solve(n, l, r, k));
    }

    sc.close();
  }

  static long solve(long n, long l, long r, long k) {
    if (n % 2 == 1) {
      return l;
    }

    long tail = Long.highestOneBit(l) * 2;
    if (n == 2 || tail > r) {
      return -1;
    }

    return (k >= n - 1) ? tail : l;
  }
}