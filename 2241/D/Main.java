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
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a, int[] b) {
    long[] values = Arrays.stream(a).asLongStream().toArray();
    for (int i = values.length - 1; i >= 1; --i) {
      if (values[i] > b[i]) {
        values[i - 1] += values[i] - b[i];
      }
    }

    return values[0] <= b[0];
  }
}