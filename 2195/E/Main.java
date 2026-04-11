import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  static final ModInt MOD_INT = new ModInt(1_000_000_007);

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] l = new int[n];
      int[] r = new int[n];
      for (int i = 0; i < n; ++i) {
        l[i] = sc.nextInt();
        r[i] = sc.nextInt();
      }

      System.out.println(solve(l, r));
    }

    sc.close();
  }

  static String solve(int[] l, int[] r) {
    int n = l.length;

    int[] subtreeTimes = new int[n + 1];
    search1(subtreeTimes, l, r, 1);

    int[] totalTimes = new int[n + 1];
    search2(totalTimes, l, r, subtreeTimes, 0, 1);

    return IntStream.range(1, totalTimes.length)
        .map(i -> totalTimes[i])
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }

  static void search2(
      int[] totalTimes, int[] l, int[] r, int[] subtreeTimes, int parent, int node) {
    totalTimes[node] = MOD_INT.addMod(MOD_INT.addMod(subtreeTimes[node], 1), totalTimes[parent]);

    if (l[node - 1] != 0) {
      search2(totalTimes, l, r, subtreeTimes, node, l[node - 1]);
      search2(totalTimes, l, r, subtreeTimes, node, r[node - 1]);
    }
  }

  static void search1(int[] subtreeTimes, int[] l, int[] r, int node) {
    if (l[node - 1] != 0) {
      search1(subtreeTimes, l, r, l[node - 1]);
      search1(subtreeTimes, l, r, r[node - 1]);

      subtreeTimes[node] =
          MOD_INT.addMod(MOD_INT.addMod(subtreeTimes[l[node - 1]], subtreeTimes[r[node - 1]]), 4);
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
