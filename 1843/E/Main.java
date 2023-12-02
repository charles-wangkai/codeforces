import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] l = new int[m];
      int[] r = new int[m];
      for (int i = 0; i < m; ++i) {
        l[i] = sc.nextInt();
        r[i] = sc.nextInt();
      }
      int q = sc.nextInt();
      int[] x = new int[q];
      for (int i = 0; i < x.length; ++i) {
        x[i] = sc.nextInt();
      }

      System.out.println(solve(n, l, r, x));
    }

    sc.close();
  }

  static int solve(int n, int[] l, int[] r, int[] x) {
    int result = -1;
    int lower = 0;
    int upper = x.length;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(n, l, r, x, middle)) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static boolean check(int n, int[] l, int[] r, int[] x, int changeNum) {
    int[] a = new int[n];
    for (int i = 0; i < changeNum; ++i) {
      a[x[i] - 1] = 1;
    }

    int[] prefixSums = new int[n];
    for (int i = 0; i < prefixSums.length; ++i) {
      prefixSums[i] = ((i == 0) ? 0 : prefixSums[i - 1]) + a[i];
    }

    return IntStream.range(0, l.length)
        .anyMatch(
            i ->
                2 * (prefixSums[r[i] - 1] - ((l[i] == 1) ? 0 : prefixSums[l[i] - 2]))
                    > r[i] - l[i] + 1);
  }
}