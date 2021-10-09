import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    long[] a = new long[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextLong();
    }
    int m = sc.nextInt();
    long[] x = new long[m];
    long[] y = new long[m];
    for (int i = 0; i < m; ++i) {
      x[i] = sc.nextLong();
      y[i] = sc.nextLong();
    }

    System.out.println(solve(a, x, y));

    sc.close();
  }

  static String solve(long[] a, long[] x, long[] y) {
    long sum = Arrays.stream(a).sum();
    long[] sorted = Arrays.stream(a).boxed().sorted().mapToLong(ai -> ai).toArray();

    return IntStream.range(0, x.length)
        .mapToObj(
            i -> {
              long result = Long.MAX_VALUE;

              int notLessIndex = findNotLessIndex(sorted, x[i]);
              if (notLessIndex != sorted.length) {
                result = Math.min(result, Math.max(0, y[i] - (sum - sorted[notLessIndex])));
              }
              if (notLessIndex != 0) {
                result =
                    Math.min(
                        result,
                        (x[i] - sorted[notLessIndex - 1])
                            + Math.max(0, y[i] - (sum - sorted[notLessIndex - 1])));
              }

              return String.valueOf(result);
            })
        .collect(Collectors.joining("\n"));
  }

  static int findNotLessIndex(long[] sorted, long target) {
    int result = sorted.length;
    int lowerIndex = 0;
    int upperIndex = sorted.length - 1;
    while (lowerIndex <= upperIndex) {
      int middleIndex = (lowerIndex + upperIndex) / 2;
      if (sorted[middleIndex] >= target) {
        result = middleIndex;
        upperIndex = middleIndex - 1;
      } else {
        lowerIndex = middleIndex + 1;
      }
    }

    return result;
  }
}
