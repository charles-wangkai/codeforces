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

      System.out.println(solve(a, b) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a, int[] b) {
    Arrays.sort(b);

    int prev = Integer.MIN_VALUE;
    for (int ai : a) {
      Integer minValue = findMinValue(b, ai, prev);
      if (ai >= prev && (minValue == null || ai < minValue)) {
        minValue = ai;
      }

      if (minValue == null) {
        return false;
      }

      prev = minValue;
    }

    return true;
  }

  static Integer findMinValue(int[] b, int ai, int prev) {
    int index = Arrays.binarySearch(b, ai + prev);
    if (index < 0) {
      index = -1 - index;
    }

    return (index == b.length) ? null : (b[index] - ai);
  }
}