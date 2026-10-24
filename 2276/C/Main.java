import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
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

  static long solve(int[] a, int k) {
    ModInt modInt = new ModInt(k);

    long result = 0;
    int[] prefixSumRemainders = new int[a.length + 1];
    Map<Integer, Integer> remainderToCount = new HashMap<>();
    for (int i = 1; i < prefixSumRemainders.length; ++i) {
      if (i >= k + 1) {
        remainderToCount.put(
            prefixSumRemainders[i - k - 1],
            remainderToCount.getOrDefault(prefixSumRemainders[i - k - 1], 0) + 1);
      }

      prefixSumRemainders[i] = modInt.addMod(prefixSumRemainders[i - 1], a[i - 1]);
      result += remainderToCount.getOrDefault(prefixSumRemainders[i], 0);
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
