import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
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
      int[] c = new int[n];
      for (int i = 0; i < c.length; ++i) {
        c[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, c));
    }

    sc.close();
  }

  static int solve(int[] a, int[] b, int[] c) {
    return IntStream.of(
            computeMaxSum(a, b, c),
            computeMaxSum(a, c, b),
            computeMaxSum(b, c, a),
            computeMaxSum(b, a, c),
            computeMaxSum(c, a, b),
            computeMaxSum(c, b, a))
        .max()
        .getAsInt();
  }

  static int computeMaxSum(int[] lefts, int[] middles, int[] rights) {
    int[] leftMaxs = new int[lefts.length];
    for (int i = 0; i < leftMaxs.length; ++i) {
      leftMaxs[i] = Math.max((i == 0) ? -1 : leftMaxs[i - 1], lefts[i]);
    }

    int[] rightMaxs = new int[rights.length];
    for (int i = rightMaxs.length - 1; i >= 0; --i) {
      rightMaxs[i] = Math.max((i == rightMaxs.length - 1) ? -1 : rightMaxs[i + 1], rights[i]);
    }

    return IntStream.range(1, middles.length - 1)
        .map(i -> leftMaxs[i - 1] + middles[i] + rightMaxs[i + 1])
        .max()
        .getAsInt();
  }
}