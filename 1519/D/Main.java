import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    int[] b = new int[n];
    for (int i = 0; i < b.length; ++i) {
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b));

    sc.close();
  }

  static long solve(int[] a, int[] b) {
    int n = a.length;

    long maxDelta = 0;
    for (int i = 0; i < n; ++i) {
      maxDelta =
          Math.max(
              maxDelta, Math.max(computeMaxDelta(a, b, i, i), computeMaxDelta(a, b, i, i + 1)));
    }

    return IntStream.range(0, n).mapToLong(i -> (long) a[i] * b[i]).sum() + maxDelta;
  }

  static long computeMaxDelta(int[] a, int[] b, int leftIndex, int rightIndex) {
    long result = 0;
    long delta = 0;
    while (leftIndex >= 0 && rightIndex < a.length) {
      delta +=
          (long) a[leftIndex] * b[rightIndex]
              + (long) a[rightIndex] * b[leftIndex]
              - (long) a[leftIndex] * b[leftIndex]
              - (long) a[rightIndex] * b[rightIndex];
      result = Math.max(result, delta);

      --leftIndex;
      ++rightIndex;
    }

    return result;
  }
}
