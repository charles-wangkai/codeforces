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
      for (int i = 0; i < q; ++i) {
        l[i] = sc.nextInt();
        r[i] = sc.nextInt();
      }

      System.out.println(solve(a, l, r));
    }

    sc.close();
  }

  static String solve(int[] a, int[] l, int[] r) {
    int[] prefixValueSums = new int[a.length];
    for (int i = 0; i < prefixValueSums.length; ++i) {
      prefixValueSums[i] = ((i == 0) ? 0 : prefixValueSums[i - 1]) + a[i];
    }

    int[] prefixSameSums = new int[a.length - 1];
    for (int i = 0; i < prefixSameSums.length; ++i) {
      prefixSameSums[i] = ((i == 0) ? 0 : prefixSameSums[i - 1]) + ((a[i] == a[i + 1]) ? 1 : 0);
    }

    return IntStream.range(0, l.length)
        .map(
            i -> {
              int length = r[i] - l[i] + 1;

              if (length % 3 != 0
                  || computeRangeSum(prefixValueSums, l[i] - 1, r[i] - 1) % 3 != 0) {
                return -1;
              }

              return length / 3
                  + ((computeRangeSum(prefixSameSums, l[i] - 1, r[i] - 2) == 0) ? 1 : 0);
            })
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }

  static int computeRangeSum(int[] prefixSums, int beginIndex, int endIndex) {
    return prefixSums[endIndex] - ((beginIndex == 0) ? 0 : prefixSums[beginIndex - 1]);
  }
}