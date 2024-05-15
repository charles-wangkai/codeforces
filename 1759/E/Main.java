import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int h = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, h));
    }

    sc.close();
  }

  static int solve(int[] a, int h) {
    return Math.max(
        Math.max(
            computeAbsorbNum(a, h, new int[] {2, 2, 3}),
            computeAbsorbNum(a, h, new int[] {2, 3, 2})),
        computeAbsorbNum(a, h, new int[] {3, 2, 2}));
  }

  static int computeAbsorbNum(int[] a, int h, int[] factors) {
    int[] sorted = Arrays.stream(a).sorted().toArray();
    int factorIndex = 0;
    long current = h;
    for (int i = 0; i < sorted.length; ++i) {
      while (current <= sorted[i] && factorIndex != factors.length) {
        current *= factors[factorIndex];
        ++factorIndex;
      }
      if (current <= sorted[i]) {
        return i;
      }

      current += sorted[i] / 2;
    }

    return sorted.length;
  }
}