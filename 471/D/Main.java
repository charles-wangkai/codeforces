import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  static final int BASE = 31;
  static final ModInt MOD_INT = new ModInt(1_000_000_007);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int w = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    int[] b = new int[w];
    for (int i = 0; i < b.length; ++i) {
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b));

    sc.close();
  }

  static int solve(int[] a, int[] b) {
    int factor = 0;
    for (int i = 0; i < b.length; ++i) {
      factor = MOD_INT.addMod(MOD_INT.multiplyMod(factor, BASE), 1);
    }

    int targetHash = 0;
    for (int bi : b) {
      targetHash = MOD_INT.addMod(MOD_INT.multiplyMod(targetHash, BASE), bi);
    }
    targetHash = MOD_INT.addMod(targetHash, -MOD_INT.multiplyMod(b[0], factor));

    int hash = 0;
    for (int i = 0; i < b.length - 1; ++i) {
      hash = MOD_INT.addMod(MOD_INT.multiplyMod(hash, BASE), a[i]);
    }

    int result = 0;
    for (int i = 0; i <= a.length - b.length; ++i) {
      hash = MOD_INT.addMod(MOD_INT.multiplyMod(hash, BASE), a[i + b.length - 1]);

      if (MOD_INT.addMod(hash, -MOD_INT.multiplyMod(a[i], factor)) == targetHash) {
        ++result;
      }

      hash = MOD_INT.addMod(hash, -MOD_INT.multiplyMod(a[i], MOD_INT.powMod(BASE, b.length - 1)));
    }

    return result;
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
