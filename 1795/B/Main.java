import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int LIMIT = 50;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] l = new int[n];
      int[] r = new int[n];
      for (int i = 0; i < n; ++i) {
        l[i] = sc.nextInt();
        r[i] = sc.nextInt();
      }

      System.out.println(solve(l, r, k) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] l, int[] r, int k) {
    int[] counts = new int[LIMIT + 1];
    for (int i = 0; i < l.length; ++i) {
      if (k >= l[i] && k <= r[i]) {
        for (int j = l[i]; j <= r[i]; ++j) {
          ++counts[j];
        }
      }
    }

    return IntStream.range(0, counts.length)
        .filter(i -> i != k)
        .allMatch(i -> counts[i] < counts[k]);
  }
}
