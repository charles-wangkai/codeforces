import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, x));
    }

    sc.close();
  }

  static int solve(int[] a, int x) {
    int result = -1;
    int lower = 0;
    int upper = Arrays.stream(a).min().getAsInt() + x;
    while (lower <= upper) {
      int middle = lower + (upper - lower) / 2;
      if (check(a, x, middle)) {
        result = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return result;
  }

  static boolean check(int[] a, int x, int h) {
    return Arrays.stream(a).map(ai -> Math.max(0, h - ai)).asLongStream().sum() <= x;
  }
}
