import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int LIMIT = 200000;
  static final int MODULUS = 998_244_353;

  static int[] factorials;
  static int[] twoPowers;

  public static void main(String[] args) {
    preprocess();

    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();

    System.out.println(solve(n, m));

    sc.close();
  }

  static void preprocess() {
    factorials = new int[LIMIT + 1];
    factorials[0] = 1;
    for (int i = 1; i < factorials.length; ++i) {
      factorials[i] = multiplyMod(factorials[i - 1], i);
    }

    twoPowers = new int[LIMIT + 1];
    twoPowers[0] = 1;
    for (int i = 1; i < twoPowers.length; ++i) {
      twoPowers[i] = multiplyMod(twoPowers[i - 1], 2);
    }
  }

  static int solve(int n, int m) {
    if (n == 2) {
      return 0;
    }

    return IntStream.rangeClosed(2, m)
        .map(peak -> multiplyMod(multiplyMod(peak - 1, CMod(peak - 2, n - 3)), twoPowers[n - 3]))
        .reduce(Main::addMod)
        .getAsInt();
  }

  static int addMod(int x, int y) {
    return Math.floorMod(x + y, MODULUS);
  }

  static int multiplyMod(int x, int y) {
    return Math.floorMod((long) x * y, MODULUS);
  }

  static int divideMod(int x, int y) {
    return multiplyMod(x, BigInteger.valueOf(y).modInverse(BigInteger.valueOf(MODULUS)).intValue());
  }

  static int CMod(int n, int r) {
    if (n < r) {
      return 0;
    }

    return divideMod(factorials[n], multiplyMod(factorials[r], factorials[n - r]));
  }
}