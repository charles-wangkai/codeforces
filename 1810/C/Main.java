import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int c = sc.nextInt();
      int d = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, c, d));
    }

    sc.close();
  }

  static long solve(int[] a, int c, int d) {
    int[] uniqueSorted = Arrays.stream(a).distinct().sorted().toArray();

    long result = (long) c * uniqueSorted.length + d;
    for (int i = 0; i < uniqueSorted.length; ++i) {
      result =
          Math.min(result, c * (uniqueSorted.length - (i + 1L)) + d * (uniqueSorted[i] - (i + 1L)));
    }
    result += (long) c * (a.length - uniqueSorted.length);

    return result;
  }
}
