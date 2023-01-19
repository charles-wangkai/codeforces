import java.util.Scanner;

public class Main {
  static final int MODULUS = 1_000_000_007;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int k = sc.nextInt();

    System.out.println(solve(k));

    sc.close();
  }

  static int solve(int k) {
    return multiplyMod(6, powMod(4, (1L << k) - 2));
  }

  static int multiplyMod(int x, int y) {
    return Math.floorMod((long) x * y, MODULUS);
  }

  static int powMod(int base, long exponent) {
    int result = 1;
    while (exponent != 0) {
      if ((exponent & 1) == 1) {
        result = multiplyMod(result, base);
      }

      base = multiplyMod(base, base);
      exponent >>= 1;
    }

    return result;
  }
}
