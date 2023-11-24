import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      long c = sc.nextLong();
      int d = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, c, d));
    }

    sc.close();
  }

  static String solve(int[] a, long c, int d) {
    int[] sorted =
        Arrays.stream(a)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

    int result = -1;
    int lower = 0;
    int upper = d - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (check(sorted, c, d, middle)) {
        result = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    if (result == -1) {
      return "Impossible";
    }
    if (result == d - 1) {
      return "Infinity";
    }

    return String.valueOf(result);
  }

  static boolean check(int[] sorted, long c, int d, int k) {
    long sum = 0;
    for (int i = 0; i < d; ++i) {
      if (i % (k + 1) < sorted.length) {
        sum += sorted[i % (k + 1)];
      }
    }

    return sum >= c;
  }
}