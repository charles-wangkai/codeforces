import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int MODULUS = 998_244_353;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();

    System.out.println(solve(n, m, k));

    sc.close();
  }

  static int solve(int n, int m, int k) {
    return multiplyMod(multiplyMod(m, powMod(m - 1, k)), CMod(n - 1, k));
  }

  static int multiplyMod(int x, int y) {
    return Math.floorMod((long) x * y, MODULUS);
  }

  static int divideMod(int x, int y) {
    return multiplyMod(x, BigInteger.valueOf(y).modInverse(BigInteger.valueOf(MODULUS)).intValue());
  }

  static int CMod(int n, int r) {
    int result = 1;
    for (int i = 0; i < r; ++i) {
      result = multiplyMod(result, divideMod(n - i, i + 1));
    }

    return result;
  }

  static int powMod(int base, int exponent) {
    return IntStream.range(0, exponent).reduce(1, (acc, x) -> multiplyMod(acc, base));
  }
}