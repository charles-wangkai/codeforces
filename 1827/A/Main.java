import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static final int MODULUS = 1_000_000_007;

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

  static int solve(int[] a, int[] b) {
    Arrays.sort(a);
    Arrays.sort(b);

    int result = 1;
    int bIndex = 0;
    for (int i = 0; i < a.length; ++i) {
      while (bIndex != b.length && b[bIndex] < a[i]) {
        ++bIndex;
      }

      result = multiplyMod(result, Math.max(0, bIndex - i));
    }

    return result;
  }

  static int multiplyMod(int x, int y) {
    return Math.floorMod((long) x * y, MODULUS);
  }
}
