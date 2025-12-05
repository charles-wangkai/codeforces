import java.util.Scanner;

public class Main {
  static final int MODULUS = 998_244_353;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static String solve(int n) {
    long firstWin = 1;
    long firstLoss = 0;
    for (int i = 4; i <= n; i += 2) {
      long nextFirstWin = C(i - 1, i / 2 - 1) + firstLoss;
      long nextFirstLoss = C(i - 2, i / 2 - 2) + firstWin;

      firstWin = nextFirstWin;
      firstLoss = nextFirstLoss;
    }

    return "%d %d 1".formatted(mod(firstWin), mod(firstLoss));
  }

  static long C(int n, int r) {
    long result = 1;
    for (int i = 0; i < r; ++i) {
      result = result * (n - i) / (i + 1);
    }

    return result;
  }

  static int mod(long x) {
    return (int) (x % MODULUS);
  }
}