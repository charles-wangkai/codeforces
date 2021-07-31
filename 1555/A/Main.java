import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long n = sc.nextLong();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static long solve(long n) {
    if (n < 6) {
      return 15;
    }

    int remainder = (int) (n % 6);
    int extra;
    if (remainder == 0) {
      extra = 0;
    } else if (remainder <= 2) {
      extra = 5;
    } else if (remainder <= 4) {
      extra = 10;
    } else {
      extra = 15;
    }

    return n / 6 * 15 + extra;
  }
}
