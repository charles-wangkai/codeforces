import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int d = sc.nextInt();

      System.out.println(solve(d));
    }

    sc.close();
  }

  static int solve(int d) {
    int p1 = findPrime(1 + d);
    int p2 = findPrime(p1 + d);

    return p1 * p2;
  }

  static int findPrime(int lower) {
    int result = lower;
    while (!isPrime(result)) {
      ++result;
    }

    return result;
  }

  static boolean isPrime(int x) {
    for (int i = 2; i * i <= x; ++i) {
      if (x % i == 0) {
        return false;
      }
    }

    return true;
  }
}
