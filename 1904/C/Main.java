import java.util.Arrays;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      long[] a = new long[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextLong();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static long solve(long[] a, int k) {
    if (k >= 3) {
      return 0;
    }

    long result = Arrays.stream(a).min().getAsLong();
    for (int i = 0; i < a.length; ++i) {
      for (int j = i + 1; j < a.length; ++j) {
        result = Math.min(result, Math.abs(a[i] - a[j]));
      }
    }

    if (k == 2) {
      NavigableSet<Long> set = new TreeSet<>(Arrays.stream(a).boxed().toList());
      for (int i = 0; i < a.length; ++i) {
        for (int j = i + 1; j < a.length; ++j) {
          long diff = Math.abs(a[i] - a[j]);

          Long floor = set.floor(diff);
          if (floor != null) {
            result = Math.min(result, diff - floor);
          }

          Long ceiling = set.ceiling(diff);
          if (ceiling != null) {
            result = Math.min(result, ceiling - diff);
          }
        }
      }
    }

    return result;
  }
}