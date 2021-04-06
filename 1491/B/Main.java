import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int u = sc.nextInt();
      int v = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, u, v));
    }

    sc.close();
  }

  static int solve(int[] a, int u, int v) {
    if (Arrays.stream(a).distinct().count() == 1) {
      return v + Math.min(u, v);
    } else if (IntStream.range(0, a.length - 1).allMatch(i -> Math.abs(a[i] - a[i + 1]) <= 1)) {
      return Math.min(u, v);
    }

    return 0;
  }
}
