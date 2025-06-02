import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  static final int MODULUS = 998_244_353;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }
      int[] q = new int[n];
      for (int i = 0; i < q.length; ++i) {
        q[i] = sc.nextInt();
      }

      System.out.println(solve(p, q));
    }

    sc.close();
  }

  static String solve(int[] p, int[] q) {
    int n = p.length;

    int[] powerMods = new int[n];
    powerMods[0] = 1;
    for (int i = 1; i < powerMods.length; ++i) {
      powerMods[i] = multiplyMod(powerMods[i - 1], 2);
    }

    int[] result = new int[n];
    int pIndex = 0;
    int qIndex = 0;
    for (int i = 0; i < result.length; ++i) {
      if (p[i] > p[pIndex]) {
        pIndex = i;
      }
      if (q[i] > q[qIndex]) {
        qIndex = i;
      }

      ExponentPair ep =
          max(
              buildExponentPair(p[pIndex], q[i - pIndex]),
              buildExponentPair(p[i - qIndex], q[qIndex]));
      result[i] = addMod(powerMods[ep.maxE()], powerMods[ep.minE()]);
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static ExponentPair buildExponentPair(int e1, int e2) {
    return new ExponentPair(Math.max(e1, e2), Math.min(e1, e2));
  }

  static ExponentPair max(ExponentPair ep1, ExponentPair ep2) {
    return (ep1.maxE() > ep2.maxE() || (ep1.maxE() == ep2.maxE() && ep1.minE() > ep2.minE()))
        ? ep1
        : ep2;
  }

  static int addMod(int x, int y) {
    return Math.floorMod(x + y, MODULUS);
  }

  static int multiplyMod(int x, int y) {
    return Math.floorMod((long) x * y, MODULUS);
  }
}

record ExponentPair(int maxE, int minE) {}
