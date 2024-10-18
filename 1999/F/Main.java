import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static final int MODULUS = 1_000_000_007;
  static final int LIMIT = 200000;

  static int[] factorials;
  static int[] factorialInvs;

  public static void main(String[] args) {
    precompute();

    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static void precompute() {
    factorials = new int[LIMIT + 1];
    factorials[0] = 1;
    for (int i = 1; i < factorials.length; ++i) {
      factorials[i] = multiplyMod(factorials[i - 1], i);
    }

    factorialInvs =
        Arrays.stream(factorials)
            .map(x -> BigInteger.valueOf(x).modInverse(BigInteger.valueOf(MODULUS)).intValue())
            .toArray();
  }

  static int solve(int[] a, int k) {
    Arrays.sort(a);

    int result = 0;
    for (int i = 0; i < a.length; ++i) {
      result =
          addMod(
              result,
              multiplyMod(a[i], multiplyMod(CMod(i, k / 2), CMod(a.length - i - 1, k / 2))));
    }

    return result;
  }

  static int CMod(int n, int r) {
    return (n < r)
        ? 0
        : multiplyMod(factorials[n], multiplyMod(factorialInvs[r], factorialInvs[n - r]));
  }

  static int addMod(int x, int y) {
    return Math.floorMod(x + y, MODULUS);
  }

  static int multiplyMod(int x, int y) {
    return Math.floorMod((long) x * y, MODULUS);
  }
}