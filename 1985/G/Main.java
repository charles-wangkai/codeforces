import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int MODULUS = 1_000_000_007;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int l = sc.nextInt();
      int r = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(l, r, k));
    }

    sc.close();
  }

  static int solve(int l, int r, int k) {
    return addMod(computeValueNum(k, r), -computeValueNum(k, l));
  }

  static int computeValueNum(int k, int limit) {
    return powMod((int) IntStream.range(0, 10).filter(i -> (long) i * k < 10).count(), limit);
  }

  static int addMod(int x, int y) {
    return Math.floorMod(x + y, MODULUS);
  }

  static int multiplyMod(int x, int y) {
    return Math.floorMod((long) x * y, MODULUS);
  }

  static int powMod(int base, int exponent) {
    if (exponent == 0) {
      return 1;
    }

    return multiplyMod(
        (exponent % 2 == 0) ? 1 : base, powMod(multiplyMod(base, base), exponent / 2));
  }
}
