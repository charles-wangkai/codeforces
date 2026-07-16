import java.util.Arrays;
import java.util.Scanner;

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

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    long[] values = Arrays.stream(a).asLongStream().toArray();
    for (int i = 0; i < values.length; ++i) {
      long prev = (i == 0) ? 0 : values[i - 1];
      if (values[i] <= prev) {
        return false;
      }

      if (i != values.length - 1) {
        long delta = values[i] - prev - 1;
        values[i] -= delta;
        values[i + 1] += delta;
      }
    }

    return true;
  }
}