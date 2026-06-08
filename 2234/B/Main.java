import java.util.Scanner;

public class Main {
  static final int[] A_CANDIDATES = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 22};

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      long n = sc.nextLong();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static String solve(long n) {
    for (int a : A_CANDIDATES) {
      long b = n - a;
      if (b >= 0 && b % 12 == 0) {
        return "%d %d".formatted(a, b);
      }
    }

    return "-1";
  }
}