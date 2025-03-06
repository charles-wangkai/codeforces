import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  static final int MODULUS = 1_000_000_007;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    int n = sc.nextInt();

    System.out.println(solve(a, b, n));

    sc.close();
  }

  static int solve(int a, int b, int n) {
    int[] factorials = new int[n + 1];
    factorials[0] = 1;
    for (int i = 1; i < factorials.length; ++i) {
      factorials[i] = multiplyMod(factorials[i - 1], i);
    }

    int result = 0;
    for (int i = 0; i <= n; ++i) {
      if (isGood(a, b, i * a + (n - i) * b)) {
        result = addMod(result, CMod(factorials, n, i));
      }
    }

    return result;
  }

  static boolean isGood(int a, int b, int x) {
    return String.valueOf(x).chars().allMatch(c -> c - '0' == a || c - '0' == b);
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

  static int CMod(int[] factorials, int n, int r) {
    return divideMod(factorials[n], multiplyMod(factorials[r], factorials[n - r]));
  }
}