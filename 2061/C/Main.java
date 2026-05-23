import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  static final ModInt MOD_INT = new ModInt(998_244_353);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[] a) {
    int[][] dp = new int[a.length][2];
    dp[0][0] = 1;
    dp[0][1] = (a[0] == 0) ? 1 : 0;

    for (int i = 1; i < dp.length; ++i) {
      dp[i][0] = dp[i - 1][1];

      if (a[i] == ((i == 1) ? 0 : a[i - 2]) + 1) {
        dp[i][1] = MOD_INT.addMod(dp[i][1], dp[i - 1][0]);
      }
      if (a[i] == a[i - 1]) {
        dp[i][1] = MOD_INT.addMod(dp[i][1], dp[i - 1][1]);
      }
    }

    return MOD_INT.addMod(dp[dp.length - 1][0], dp[dp.length - 1][1]);
  }
}

class ModInt {
  int modulus;

  ModInt(int modulus) {
    this.modulus = modulus;
  }

  int mod(long x) {
    return Math.floorMod(x, modulus);
  }

  int modInv(int x) {
    return BigInteger.valueOf(x).modInverse(BigInteger.valueOf(modulus)).intValue();
  }

  int addMod(int x, int y) {
    return mod(x + y);
  }

  int multiplyMod(int x, int y) {
    return mod((long) x * y);
  }

  int divideMod(int x, int y) {
    return multiplyMod(x, modInv(y));
  }

  int powMod(int base, long exponent) {
    if (exponent == 0) {
      return 1;
    }

    return multiplyMod(
        (exponent % 2 == 0) ? 1 : base, powMod(multiplyMod(base, base), exponent / 2));
  }
}
