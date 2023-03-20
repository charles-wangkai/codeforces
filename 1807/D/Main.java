import java.util.Arrays;
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
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] l = new int[q];
      int[] r = new int[q];
      int[] k = new int[q];
      for (int i = 0; i < q; ++i) {
        l[i] = sc.nextInt() - 1;
        r[i] = sc.nextInt() - 1;
        k[i] = sc.nextInt();
      }

      System.out.println(solve(a, l, r, k));
    }

    sc.close();
  }

  static String solve(int[] a, int[] l, int[] r, int[] k) {
    long total = Arrays.stream(a).asLongStream().sum();

    long[] prefixSums = new long[a.length];
    for (int i = 0; i < prefixSums.length; ++i) {
      prefixSums[i] = ((i == 0) ? 0 : prefixSums[i - 1]) + a[i];
    }

    return IntStream.range(0, l.length)
        .mapToObj(
            i ->
                ((total
                                - (prefixSums[r[i]] - ((l[i] == 0) ? 0 : prefixSums[l[i] - 1]))
                                + (r[i] - l[i] + 1L) * k[i])
                            % 2
                        == 1)
                    ? "YES"
                    : "NO")
        .collect(Collectors.joining("\n"));
  }
}
