import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int BIT_NUM = 20;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static String solve(int[] a, int[] b) {
    for (int p = BIT_NUM - 1; p >= 0; --p) {
      int p_ = p;
      int outcome =
          computeOutcomeForBit(
              Arrays.stream(a).map(ai -> (ai >> p_) & 1).toArray(),
              Arrays.stream(b).map(bi -> (bi >> p_) & 1).toArray());
      if (outcome == -1) {
        return "Ajisai";
      }
      if (outcome == 1) {
        return "Mai";
      }
    }

    return "Tie";
  }

  static int computeOutcomeForBit(int[] aBits, int[] bBits) {
    if (IntStream.concat(Arrays.stream(aBits), Arrays.stream(bBits))
            .reduce((acc, x) -> acc ^ x)
            .getAsInt()
        == 0) {
      return 0;
    }

    return (IntStream.range(0, aBits.length).filter(i -> aBits[i] != bBits[i]).max().getAsInt() % 2
            == 0)
        ? -1
        : 1;
  }
}