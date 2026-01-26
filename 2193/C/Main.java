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
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }
      int[] l = new int[q];
      int[] r = new int[q];
      for (int i = 0; i < q; ++i) {
        l[i] = sc.nextInt();
        r[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, l, r));
    }

    sc.close();
  }

  static String solve(int[] a, int[] b, int[] l, int[] r) {
    int[] values = new int[a.length];
    for (int i = values.length - 1; i >= 0; --i) {
      values[i] =
          Math.max(
              (i == values.length - 1) ? Integer.MIN_VALUE : values[i + 1], Math.max(a[i], b[i]));
    }

    int[] prefixSums = new int[values.length + 1];
    for (int i = 1; i < prefixSums.length; ++i) {
      prefixSums[i] = prefixSums[i - 1] + values[i - 1];
    }

    return IntStream.range(0, l.length)
        .map(i -> prefixSums[r[i]] - prefixSums[l[i] - 1])
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}