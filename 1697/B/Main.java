import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int q = sc.nextInt();
    int[] p = new int[n];
    for (int i = 0; i < p.length; ++i) {
      p[i] = sc.nextInt();
    }
    int[] x = new int[q];
    int[] y = new int[q];
    for (int i = 0; i < q; ++i) {
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    System.out.println(solve(p, x, y));

    sc.close();
  }

  static String solve(int[] p, int[] x, int[] y) {
    int[] sorted =
        Arrays.stream(p).boxed().sorted(Comparator.reverseOrder()).mapToInt(pi -> pi).toArray();

    long[] prefixSums = new long[sorted.length];
    for (int i = 0; i < prefixSums.length; ++i) {
      prefixSums[i] = ((i == 0) ? 0 : prefixSums[i - 1]) + sorted[i];
    }

    return IntStream.range(0, x.length)
        .mapToLong(i -> prefixSums[x[i] - 1] - ((x[i] == y[i]) ? 0 : prefixSums[x[i] - y[i] - 1]))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}