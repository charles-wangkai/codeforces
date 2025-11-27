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

    System.out.println(solve(a));

    sc.close();
  }

  static String solve(long[] a) {
    long total = Arrays.stream(a).sum();

    return IntStream.rangeClosed(0, 100)
        .filter(
            percentage -> {
              long lower = computeLower(total, percentage);
              long upper = computeUpper(total, percentage);

              long prevSum = 0;
              for (long ai : a) {
                long l = computeLower(ai, percentage);
                long u = computeUpper(ai, percentage);
                if (hasOverlap(lower, upper, prevSum + l, prevSum + u)) {
                  return true;
                }

                prevSum += ai;
              }

              return false;
            })
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }

  static boolean hasOverlap(long lower1, long upper1, long lower2, long upper2) {
    return Math.max(lower1, lower2) <= Math.min(upper1, upper2);
  }

  static long computeLower(long n, int percentage) {
    return Math.ceilDiv(n * percentage, 100);
  }

  static long computeUpper(long n, int percentage) {
    long result = Math.min(n, n * (percentage + 1) / 100);
    if (result * 100 / n == percentage + 1) {
      --result;
    }

    return result;
  }
}