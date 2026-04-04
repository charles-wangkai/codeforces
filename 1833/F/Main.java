import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  static final ModInt MOD_INT = new ModInt(1_000_000_007);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, m));
    }

    sc.close();
  }

  static int solve(int[] a, int m) {
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int ai : a) {
      valueToCount.put(ai, valueToCount.getOrDefault(ai, 0) + 1);
    }

    Element[] elements =
        valueToCount.keySet().stream()
            .sorted()
            .map(value -> new Element(value, valueToCount.get(value)))
            .toArray(Element[]::new);
    if (elements.length < m) {
      return 0;
    }

    State state = new State();
    for (int i = 0; i < m - 1; ++i) {
      state.add(elements[i].count());
    }

    int result = 0;
    for (int i = m - 1; i < elements.length; ++i) {
      state.add(elements[i].count());

      result =
          MOD_INT.addMod(
              result,
              (state.zeroCount == 0 && elements[i].value() - elements[i - m + 1].value() == m - 1)
                  ? state.product
                  : 0);

      state.remove(elements[i - m + 1].count());
    }

    return result;
  }
}

record Element(int value, int count) {}

class State {
  int zeroCount;
  int product = 1;

  void add(int x) {
    if (x == 0) {
      ++zeroCount;
    } else {
      product = Main.MOD_INT.multiplyMod(product, x);
    }
  }

  void remove(int x) {
    if (x == 0) {
      --zeroCount;
    } else {
      product = Main.MOD_INT.divideMod(product, x);
    }
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
