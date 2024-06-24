import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long a = sc.nextLong();
      long b = sc.nextLong();

      System.out.println(solve(a, b) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(long a, long b) {
    return a - b == 1 && isPrime(a + b);
  }

  static boolean isPrime(long x) {
    for (int i = 2; (long) i * i <= x; ++i) {
      if (x % i == 0) {
        return false;
      }
    }

    return true;
  }
}