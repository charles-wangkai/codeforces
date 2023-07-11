import java.util.Scanner;

public class Main {
  static final int LIMIT = 1_000_000;

  static boolean[] constructed;

  public static void main(String[] args) {
    precompute();

    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n) ? "YES" : "NO");
    }

    sc.close();
  }

  static void precompute() {
    constructed = new boolean[LIMIT + 1];
    for (int k = 2; k * k <= LIMIT; ++k) {
      int sum = 0;
      for (int power = 1; ; power *= k) {
        sum += power;
        if (sum >= constructed.length) {
          break;
        }

        if (power > k) {
          constructed[sum] = true;
        }
      }
    }
  }

  static boolean solve(int n) {
    return constructed[n];
  }
}
