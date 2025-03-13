import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int MODULUS = 998_244_353;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] w = new int[n];
    for (int i = 0; i < w.length; ++i) {
      w[i] = sc.nextInt();
    }

    System.out.println(solve(w));

    sc.close();
  }

  static int solve(int[] w) {
    int n = w.length;

    return multiplyMod(
        CMod(n / 3, n / 6),
        IntStream.range(0, n / 3)
            .map(
                i ->
                    computeWayNum(
                        IntStream.of(w[i * 3], w[i * 3 + 1], w[i * 3 + 2]).sorted().toArray()))
            .reduce(Main::multiplyMod)
            .getAsInt());
  }

  static int computeWayNum(int[] weights) {
    if (weights[2] == weights[1]) {
      return (weights[1] == weights[0]) ? 3 : 1;
    }

    return (weights[1] == weights[0]) ? 2 : 1;
  }

  static int multiplyMod(int x, int y) {
    return Math.floorMod((long) x * y, MODULUS);
  }

  static int divideMod(int x, int y) {
    return multiplyMod(x, BigInteger.valueOf(y).modInverse(BigInteger.valueOf(MODULUS)).intValue());
  }

  static int CMod(int n, int r) {
    int numer = 1;
    int denom = 1;
    for (int i = 0; i < r; ++i) {
      numer = multiplyMod(numer, n - i);
      denom = multiplyMod(denom, i + 1);
    }

    return divideMod(numer, denom);
  }
}