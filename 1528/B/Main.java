import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  static final ModInt MOD_INT = new ModInt(998_244_353);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    System.out.println(solve(n));

    sc.close();
  }

  static int solve(int n) {
    int[] divisorCounts = buildDivisorCounts(n);

    int sum = 1;
    int next = -1;
    for (int i = 1; i <= n; ++i) {
      next = MOD_INT.addMod(sum, divisorCounts[i] - 1);
      sum = MOD_INT.addMod(sum, next);
    }

    return next;
  }

  static int[] buildDivisorCounts(int n) {
    int[] result = new int[n + 1];
    for (int i = 1; i <= n; ++i) {
      for (int j = i; j <= n; j += i) {
        ++result[j];
      }
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
