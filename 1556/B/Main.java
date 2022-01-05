import java.util.Scanner;
import java.util.stream.IntStream;

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

      System.out.println(solve(a));
    }

    sc.close();
  }

  static long solve(int[] a) {
    int[] evenIndices = IntStream.range(0, a.length).filter(i -> a[i] % 2 == 0).toArray();
    int[] oddIndices = IntStream.range(0, a.length).filter(i -> a[i] % 2 != 0).toArray();

    int[] largeIndices;
    int[] smallIndices;
    if (evenIndices.length >= oddIndices.length) {
      largeIndices = evenIndices;
      smallIndices = oddIndices;
    } else {
      largeIndices = oddIndices;
      smallIndices = evenIndices;
    }

    if (largeIndices.length - smallIndices.length >= 2) {
      return -1;
    }

    long result =
        computeDiffSum(
            largeIndices, IntStream.range(0, largeIndices.length).map(i -> i * 2).toArray());
    if (largeIndices.length == smallIndices.length) {
      result =
          Math.min(
              result,
              computeDiffSum(
                  largeIndices,
                  IntStream.range(0, largeIndices.length).map(i -> i * 2 + 1).toArray()));
    }

    return result;
  }

  static long computeDiffSum(int[] x, int[] y) {
    return IntStream.range(0, x.length).map(i -> Math.abs(x[i] - y[i])).asLongStream().sum();
  }
}
