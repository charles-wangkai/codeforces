import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static final int MODULUS = 1_000_000_007;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, m, k));
    }

    sc.close();
  }

  static int solve(int[] a, int m, int k) {
    Arrays.sort(a);

    int result = 0;
    int endIndex = -1;
    for (int beginIndex = 0; beginIndex < a.length; ++beginIndex) {
      while (endIndex != a.length - 1 && a[endIndex + 1] - a[beginIndex] <= k) {
        ++endIndex;
      }

      result = addMod(result, CMod(endIndex - beginIndex, m - 1));
    }

    return result;
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

    int numerator = 1;
    for (int i = 0; i < r; ++i) {
      numerator = multiplyMod(numerator, n - i);
    }

    int denominator = 1;
    for (int i = 0; i < r; ++i) {
      denominator = multiplyMod(denominator, i + 1);
    }

    return divideMod(numerator, denominator);
  }
}
