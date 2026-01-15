import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static final ModInt MOD_INT = new ModInt(1_000_000_007);
  static final int LIMIT = 64;

  public static void main(String[] args) {
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

  static int solve(int[] a, int k) {
    int[] counts = new int[LIMIT];
    for (int ai : a) {
      ++counts[ai];
    }

    int[] supersetWayNums = new int[LIMIT];
    Arrays.fill(supersetWayNums, 1);
    for (int i = 0; i < LIMIT; ++i) {
      for (int j = 0; j < LIMIT; ++j) {
        if ((i & j) == j) {
          supersetWayNums[j] =
              MOD_INT.multiplyMod(supersetWayNums[j], MOD_INT.powMod(2, counts[i]));
        }
      }
    }

    int result = 0;
    for (int i = 0; i < LIMIT; ++i) {
      if (Integer.bitCount(i) == k) {
        int wayNum = 0;
        for (int j = 0; j < LIMIT; ++j) {
          if ((j & i) == i) {
            wayNum =
                MOD_INT.addMod(
                    wayNum,
                    (((Integer.bitCount(j) - Integer.bitCount(i)) % 2 == 0) ? 1 : -1)
                        * (supersetWayNums[j] - 1));
          }
        }

        result = MOD_INT.addMod(result, wayNum);
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
