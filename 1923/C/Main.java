import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int q = sc.nextInt();
      int[] c = new int[n];
      for (int i = 0; i < c.length; ++i) {
        c[i] = sc.nextInt();
      }
      int[] l = new int[q];
      int[] r = new int[q];
      for (int i = 0; i < q; ++i) {
        l[i] = sc.nextInt();
        r[i] = sc.nextInt();
      }

      System.out.println(solve(c, l, r));
    }

    sc.close();
  }

  static String solve(int[] c, int[] l, int[] r) {
    int n = c.length;

    long[] prefixDeltaSums = new long[n + 1];
    for (int i = 1; i < prefixDeltaSums.length; ++i) {
      prefixDeltaSums[i] = prefixDeltaSums[i - 1] + (c[i - 1] - 1);
    }

    int[] onePrefixCounts = new int[n + 1];
    for (int i = 1; i < onePrefixCounts.length; ++i) {
      onePrefixCounts[i] = onePrefixCounts[i - 1] + ((c[i - 1] == 1) ? 1 : 0);
    }

    return IntStream.range(0, l.length)
        .mapToObj(
            i ->
                l[i] != r[i]
                    && prefixDeltaSums[r[i]] - prefixDeltaSums[l[i] - 1]
                        >= onePrefixCounts[r[i]] - onePrefixCounts[l[i] - 1])
        .map(x -> x ? "YES" : "NO")
        .collect(Collectors.joining("\n"));
  }
}