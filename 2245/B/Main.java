import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int c = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, c));
    }

    sc.close();
  }

  static long solve(int[] a, int c) {
    int[] sorted =
        Arrays.stream(a)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

    long result = Long.MIN_VALUE;
    long sum = 0;
    for (int i = 0; i < sorted.length; ++i) {
      sum += sorted[i];
      if ((i + 1) * 2 >= sorted.length) {
        result = Math.max(result, sum - (i + 1L) * c);
      }
    }

    return result;
  }
}