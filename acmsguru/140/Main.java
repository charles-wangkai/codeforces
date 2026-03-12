// https://www.cnblogs.com/Astronaut0142/p/15085858.html
// https://cp-algorithms.com/algebra/extended-euclid-algorithm.html
// https://chatgpt.com/share/69b27c98-4fe8-8002-881b-2321b54dee46

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int P = sc.nextInt();
    int B = sc.nextInt();
    int[] A = new int[N];
    for (int i = 0; i < A.length; ++i) {
      A[i] = sc.nextInt();
    }

    System.out.println(solve(A, P, B));

    sc.close();
  }

  static String solve(int[] A, int P, int B) {
    int N = A.length;

    ModInt modInt = new ModInt(P);

    int[] m = new int[N + 2];
    for (int i = 1; i <= N; ++i) {
      m[i] = modInt.mod(A[i - 1]);
    }
    m[N + 1] = P;

    int g = m[1];
    int[] x = new int[N + 1];
    int[] y = new int[N + 1];
    for (int i = 1; i <= N; ++i) {
      GcdOutcome outcome = extendGcd(g, m[i + 1]);

      g = outcome.g();
      x[i] = outcome.x();
      y[i] = outcome.y();
    }
    if (B % g != 0) {
      return "NO";
    }

    int[] sequence = new int[N];
    int k = B / g;
    y[0] = 1;
    for (int i = N; i >= 1; --i) {
      k = modInt.multiplyMod(k, x[i]);
      sequence[i - 1] = modInt.multiplyMod(k, y[i - 1]);
    }

    return "YES\n%s"
        .formatted(
            Arrays.stream(sequence).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }

  static GcdOutcome extendGcd(int a, int b) {
    if (b == 0) {
      return new GcdOutcome(a, 1, 0);
    }

    GcdOutcome outcome = extendGcd(b, a % b);

    return new GcdOutcome(outcome.g(), outcome.y(), outcome.x() - outcome.y() * (a / b));
  }
}

record GcdOutcome(int g, int x, int y) {}

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
