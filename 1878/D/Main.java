import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      sc.nextInt();
      int k = sc.nextInt();
      String s = sc.next();
      int[] l = new int[k];
      for (int i = 0; i < l.length; ++i) {
        l[i] = sc.nextInt();
      }
      int[] r = new int[k];
      for (int i = 0; i < r.length; ++i) {
        r[i] = sc.nextInt();
      }
      int q = sc.nextInt();
      int[] x = new int[q];
      for (int i = 0; i < x.length; ++i) {
        x[i] = sc.nextInt();
      }

      System.out.println(solve(s, l, r, x));
    }

    sc.close();
  }

  static String solve(String s, int[] l, int[] r, int[] x) {
    Arrays.sort(x);

    StringBuilder result = new StringBuilder();
    int xIndex = 0;
    for (int i = 0; i < l.length; ++i) {
      boolean[] reversed = new boolean[r[i] - l[i] + 1];
      while (xIndex != x.length && x[xIndex] <= r[i]) {
        reversed[Math.min(x[xIndex], l[i] + r[i] - x[xIndex]) - l[i]] ^= true;
        ++xIndex;
      }

      result.append(computePart(s.substring(l[i] - 1, r[i]), reversed));
    }

    return result.toString();
  }

  static String computePart(String str, boolean[] reversed) {
    char[] result = new char[str.length()];
    boolean swapped = false;
    for (int i = 0, j = result.length - 1; i <= j; ++i, --j) {
      swapped ^= reversed[i];
      if (swapped) {
        result[i] = str.charAt(j);
        result[j] = str.charAt(i);
      } else {
        result[i] = str.charAt(i);
        result[j] = str.charAt(j);
      }
    }

    return String.valueOf(result);
  }
}