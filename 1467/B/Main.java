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

  static int solve(int[] a) {
    int n = a.length;

    int[] leftCounts = new int[n];
    for (int i = 1; i < leftCounts.length; ++i) {
      leftCounts[i] = leftCounts[i - 1] + (isExtreme(a, i) ? 1 : 0);
    }

    int[] rightCounts = new int[n];
    for (int i = rightCounts.length - 2; i >= 0; --i) {
      rightCounts[i] = rightCounts[i + 1] + (isExtreme(a, i) ? 1 : 0);
    }

    return Math.min(
        (int) IntStream.range(0, a.length).filter(i -> isExtreme(a, i)).count(),
        IntStream.range(0, n)
            .map(
                i -> {
                  int result = Integer.MAX_VALUE;
                  if (i != 0) {
                    int old = a[i];
                    a[i] = a[i - 1];
                    result =
                        Math.min(
                            result,
                            ((i == 1) ? 0 : leftCounts[i - 2])
                                + (isExtreme(a, i + 1) ? 1 : 0)
                                + ((i + 2 < n) ? rightCounts[i + 2] : 0));
                    a[i] = old;
                  }
                  if (i != n - 1) {
                    int old = a[i];
                    a[i] = a[i + 1];
                    result =
                        Math.min(
                            result,
                            ((i == n - 2) ? 0 : rightCounts[i + 2])
                                + (isExtreme(a, i - 1) ? 1 : 0)
                                + ((i >= 2) ? leftCounts[i - 2] : 0));
                    a[i] = old;
                  }

                  return result;
                })
            .min()
            .getAsInt());
  }

  static boolean isExtreme(int[] a, int index) {
    return index >= 1
        && index <= a.length - 2
        && Integer.signum(a[index] - a[index - 1]) * Integer.signum(a[index] - a[index + 1]) == 1;
  }
}
