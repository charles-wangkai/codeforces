import java.util.Arrays;
import java.util.Scanner;

public class Main {
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
      int[] b = new int[m];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static long solve(int[] a, int[] b) {
    Arrays.sort(a);
    Arrays.sort(b);

    long result = 0;
    int aLeftIndex = 0;
    int aRightIndex = a.length - 1;
    int bLeftIndex = 0;
    int bRightIndex = b.length - 1;
    for (int i = 0; i < a.length; ++i) {
      int maxDiff =
          Math.max(
              Math.abs(a[aLeftIndex] - b[bRightIndex]), Math.abs(a[aRightIndex] - b[bLeftIndex]));
      result += maxDiff;

      if (Math.abs(a[aLeftIndex] - b[bRightIndex]) == maxDiff) {
        ++aLeftIndex;
        --bRightIndex;
      } else {
        --aRightIndex;
        ++bLeftIndex;
      }
    }

    return result;
  }
}