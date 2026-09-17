import java.math.BigInteger;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, m));

    sc.close();
  }

  static int solve(int[] a, int m) {
    int n = a.length;

    ModInt modInt = new ModInt(m);

    if (n == 1) {
      return modInt.mod(a[0]);
    }

    int leftHalf = n / 2;

    NavigableSet<Integer> leftSums = new TreeSet<>();
    for (int mask = 0; mask < 1 << leftHalf; ++mask) {
      int mask_ = mask;
      leftSums.add(
          IntStream.range(0, leftHalf)
              .filter(i -> ((mask_ >> i) & 1) == 1)
              .map(i -> a[i])
              .reduce(0, modInt::addMod));
    }

    int rightHalf = n - leftHalf;

    return IntStream.range(0, 1 << rightHalf)
        .map(
            mask -> {
              int rightSum =
                  IntStream.range(0, rightHalf)
                      .filter(i -> ((mask >> i) & 1) == 1)
                      .map(i -> a[leftHalf + i])
                      .reduce(0, modInt::addMod);

              int target = modInt.addMod(m - 1, -rightSum);

              Integer leftSum = leftSums.floor(target);
              if (leftSum == null) {
                leftSum = leftSums.last();
              }

              return modInt.addMod(leftSum, rightSum);
            })
        .max()
        .getAsInt();
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
