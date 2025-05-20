import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();

      System.out.println(solve(n, x));
    }

    sc.close();
  }

  static int solve(int n, int x) {
    if (x == 0) {
      if (n == 1) {
        return -1;
      }

      return (n % 2 == 0) ? n : (n + 3);
    }

    int bitCount = Integer.bitCount(x);
    if (bitCount >= n) {
      return x;
    }

    int rest = n - bitCount;
    if (rest % 2 == 0) {
      return x + rest;
    }

    if (bitCount == 1) {
      for (int i = 1; ; i *= 2) {
        if ((x & i) == 0) {
          return x + rest - 1 + 2 * i;
        }
      }
    }

    return x + rest + 1;
  }
}