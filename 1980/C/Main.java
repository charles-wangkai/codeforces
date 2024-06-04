import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
      int m = sc.nextInt();
      int[] d = new int[m];
      for (int i = 0; i < d.length; ++i) {
        d[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, d) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a, int[] b, int[] d) {
    if (Arrays.stream(b).allMatch(bi -> bi != d[d.length - 1])) {
      return false;
    }

    Map<Integer, Integer> valueToDiffCount = new HashMap<>();
    for (int i = 0; i < b.length; ++i) {
      if (b[i] != a[i]) {
        valueToDiffCount.put(b[i], valueToDiffCount.getOrDefault(b[i], 0) + 1);
      }
    }

    for (int i = d.length - 1; i >= 0; --i) {
      if (valueToDiffCount.getOrDefault(d[i], 0) != 0) {
        valueToDiffCount.put(d[i], valueToDiffCount.get(d[i]) - 1);
      }
    }

    return valueToDiffCount.values().stream().allMatch(diffCount -> diffCount == 0);
  }
}