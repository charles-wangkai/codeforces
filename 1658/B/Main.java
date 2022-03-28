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

  static int solve(int n) {
    if (n % 2 != 0) {
      return 0;
    }

    int result = 1;
    for (int i = 1; i <= n / 2; ++i) {
      result = multiplyMod(result, i);
    }
    result = multiplyMod(result, result);

    return result;
  }

  static int multiplyMod(int x, int y) {
    return (int) ((long) x * y % MODULUS);
  }
}