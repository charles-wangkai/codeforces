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
    if (Integer.bitCount(m / gcd(n, m)) != 1) {
      return -1;
    }

    long result = 0;
    while (n != 0) {
      n %= m;
      result += n;

      n <<= 1;
    }

    return result;
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}