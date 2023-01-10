import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int MODULUS = 998_244_353;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[] a) {
    int[] sorted =
        Arrays.stream(a).boxed().sorted(Comparator.reverseOrder()).mapToInt(x -> x).toArray();
    if (sorted[0] > sorted[1] + 1) {
      return 0;
    }
    if (sorted[0] == sorted[1]) {
      return factorialMod(a.length);
    }

    int secondCount = (int) Arrays.stream(a).filter(x -> x == sorted[1]).count();

    return multiplyMod(
        multiplyMod(
            CMod(a.length, secondCount + 1), multiplyMod(secondCount, factorialMod(secondCount))),
        factorialMod(a.length - 1 - secondCount));
  }

  static int multiplyMod(int x, int y) {
    return Math.floorMod((long) x * y, MODULUS);
  }

  static int modInv(int x) {
    return BigInteger.valueOf(x).modInverse(BigInteger.valueOf(MODULUS)).intValue();
  }

  static int factorialMod(int x) {
    return IntStream.rangeClosed(1, x).reduce(1, Main::multiplyMod);
  }

  static int CMod(int n, int r) {
    return multiplyMod(factorialMod(n), modInv(multiplyMod(factorialMod(r), factorialMod(n - r))));
  }
}
