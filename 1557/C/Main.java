import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  static final ModInt MOD_INT = new ModInt(1_000_000_007);
  static final int LIMIT = 200000;

  static int[] modInvs;

  public static void main(String[] args) {
    precompute();

    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();

      System.out.println(solve(n, k));
    }

    sc.close();
  }

  static void precompute() {
    modInvs = new int[LIMIT + 1];
    for (int i = 1; i < modInvs.length; ++i) {
      modInvs[i] = MOD_INT.modInv(i);
    }
  }

  static int solve(int n, int k) {
    int greaterNum = (n % 2 == 0) ? 1 : 0;

    int equalNum = ((n % 2 == 1) ? 1 : 0) + 1;
    int c = 1;
    for (int i = 1; i < n; ++i) {
      c = MOD_INT.multiplyMod(c, MOD_INT.multiplyMod(n - i + 1, modInvs[i]));
      if (i % 2 == 0) {
        equalNum = MOD_INT.addMod(equalNum, c);
      }
    }

    int result = 0;
    int strictNum = 1;
    int power = MOD_INT.powMod(2, (k - 1L) * n);
    int factor = MOD_INT.modInv(MOD_INT.powMod(2, n));
    for (int i = 0; i < k; ++i) {
      result =
          MOD_INT.addMod(
              result, MOD_INT.multiplyMod(MOD_INT.multiplyMod(strictNum, greaterNum), power));
      power = MOD_INT.multiplyMod(power, factor);

      strictNum = MOD_INT.multiplyMod(strictNum, equalNum);
    }
    result = MOD_INT.addMod(result, strictNum);

    return result;
  }
}

class ModInt {
  int modulus;

  ModInt(int modulus) {
    this.modulus = modulus;
  }

  int mod(long x) {
    return (int) (x % modulus);
  }

  int modInv(int x) {
    return BigInteger.valueOf(x).modInverse(BigInteger.valueOf(modulus)).intValue();
  }

  int addMod(int x, int y) {
    return Math.floorMod(x + y, modulus);
  }

  int multiplyMod(int x, int y) {
    return Math.floorMod((long) x * y, modulus);
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
