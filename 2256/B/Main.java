import static java.util.Map.entry;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  static final ModInt MOD_INT = new ModInt(998_244_353);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      String s = sc.next();

      System.out.println(solve(s));
    }

    sc.close();
  }

  static int solve(String s) {
    Map<State, Integer> dp =
        (s.charAt(0) == '?')
            ? Map.ofEntries(entry(new State(0, -1), 1), entry(new State(1, -1), 1))
            : Map.of(new State(s.charAt(0) - '0', -1), 1);
    for (int i = 1; i < s.length(); ++i) {
      Map<State, Integer> nextDp = new HashMap<>();

      for (int digit = 0; digit <= 1; ++digit) {
        if (s.charAt(i) == '?' || s.charAt(i) - '0' == digit) {
          for (State state : dp.keySet()) {
            int weight = state.digit() + digit;
            if (weight != state.weight()) {
              State nextState = new State(digit, weight);
              nextDp.put(
                  nextState, MOD_INT.addMod(nextDp.getOrDefault(nextState, 0), dp.get(state)));
            }
          }
        }
      }

      dp = nextDp;
    }

    return dp.values().stream().reduce(0, MOD_INT::addMod);
  }
}

record State(int digit, int weight) {}

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
