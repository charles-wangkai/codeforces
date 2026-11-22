import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final ModInt MOD_INT = new ModInt(998_244_353);

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] l = new int[n];
      int[] r = new int[n];
      int[] p = new int[n];
      int[] q = new int[n];
      for (int i = 0; i < n; ++i) {
        l[i] = sc.nextInt();
        r[i] = sc.nextInt();
        p[i] = sc.nextInt();
        q[i] = sc.nextInt();
      }

      System.out.println(solve(l, r, p, q, m));
    }
  }

  static int solve(int[] l, int[] r, int[] p, int[] q, int m) {
    Rational[] dp = new Rational[m + 1];
    Arrays.fill(dp, new Rational(0, 1));

    dp[0] = new Rational(1, 1);
    for (int i = 0; i < p.length; ++i) {
      dp[0] = Rational.multiply(dp[0], new Rational(q[i] - p[i], q[i]));
    }

    int[] sortedIndices =
        IntStream.range(0, r.length)
            .boxed()
            .sorted(Comparator.comparing(i -> r[i]))
            .mapToInt(Integer::intValue)
            .toArray();

    for (int index : sortedIndices) {
      dp[r[index]] =
          Rational.add(
              dp[r[index]],
              Rational.multiply(
                  dp[l[index] - 1],
                  Rational.divide(
                      new Rational(p[index], q[index]),
                      new Rational(q[index] - p[index], q[index]))));
    }

    return MOD_INT.divideMod(dp[m].numerator(), dp[m].denominator());
  }
}

record Rational(int numerator, int denominator) {
  static Rational add(Rational r1, Rational r2) {
    return new Rational(
        Main.MOD_INT.addMod(
            Main.MOD_INT.multiplyMod(r1.numerator, r2.denominator),
            Main.MOD_INT.multiplyMod(r2.numerator, r1.denominator)),
        Main.MOD_INT.multiplyMod(r1.denominator, r2.denominator));
  }

  static Rational multiply(Rational r1, Rational r2) {
    return new Rational(
        Main.MOD_INT.multiplyMod(r1.numerator, r2.numerator),
        Main.MOD_INT.multiplyMod(r1.denominator, r2.denominator));
  }

  static Rational divide(Rational r1, Rational r2) {
    return multiply(r1, new Rational(r2.denominator, r2.numerator));
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
