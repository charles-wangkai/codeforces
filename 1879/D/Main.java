import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final ModInt MOD_INT = new ModInt(998_244_353);
  static final int BIT_NUM = 30;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static int solve(int[] a) {
    return IntStream.range(0, BIT_NUM)
        .map(
            b ->
                MOD_INT.multiplyMod(
                    MOD_INT.mod(
                        computeContributionForOneBit(
                            Arrays.stream(a).map(ai -> (ai >> b) & 1).toArray())),
                    1 << b))
        .reduce(MOD_INT::addMod)
        .getAsInt();
  }

  static long computeContributionForOneBit(int[] values) {
    int[] counts = new int[2];
    counts[0] = 1;

    long[] lengthSums = new long[2];

    long result = 0;
    int prefixSum = 0;
    for (int i = 0; i < values.length; ++i) {
      prefixSum = (prefixSum + values[i]) % 2;

      result += (i + 1L) * counts[1 - prefixSum] - lengthSums[1 - prefixSum];

      ++counts[prefixSum];
      lengthSums[prefixSum] += i + 1;
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
