import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int MODULUS = 1_000_000_007;

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

  static int solve(int[] a, int k) {
    int[] sorted =
        Arrays.stream(a).boxed().sorted(Comparator.reverseOrder()).mapToInt(x -> x).toArray();

    return C(
        (int) Arrays.stream(sorted).filter(x -> x == sorted[k - 1]).count(),
        (int) IntStream.range(0, k).filter(i -> sorted[i] == sorted[k - 1]).count());
  }

  static int C(int n, int r) {
    int result = 1;
    for (int i = 0; i < r; ++i) {
      result = multiplyMod(result, divideMod(n - i, i + 1));
    }

    return result;
  }

  static int multiplyMod(int x, int y) {
    return (int) ((long) x * y % MODULUS);
  }

  static int divideMod(int x, int y) {
    return multiplyMod(x, BigInteger.valueOf(y).modInverse(BigInteger.valueOf(MODULUS)).intValue());
  }
}