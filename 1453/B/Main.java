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
    return IntStream.range(0, a.length - 1).map(i -> Math.abs(a[i] - a[i + 1])).asLongStream().sum()
        + IntStream.range(0, a.length)
            .map(
                i ->
                    Math.min(computeGap(a, i, i - 1), computeGap(a, i, i + 1))
                        - computeGap(a, i, i))
            .min()
            .getAsInt();
  }

  static int computeGap(int[] a, int index, int targetIndex) {
    if (targetIndex == -1 || targetIndex == a.length) {
      return Integer.MAX_VALUE;
    }

    int before = (index == 0) ? a[targetIndex] : a[index - 1];
    int after = (index == a.length - 1) ? a[targetIndex] : a[index + 1];

    return Math.abs(before - a[targetIndex]) + Math.abs(after - a[targetIndex]);
  }
}
