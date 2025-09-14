import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[n];
      int[] b = new int[n];
      for (int i = 0; i < n; ++i) {
        a[i] = sc.nextInt();
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, m));
    }

    sc.close();
  }

  static int solve(int[] a, int[] b, int m) {
    return IntStream.range(0, a.length)
            .map(i -> computePointNum((i == 0) ? 0 : a[i - 1], (i == 0) ? 0 : b[i - 1], a[i], b[i]))
            .sum()
        + (m - a[a.length - 1]);
  }

  static int computePointNum(int a1, int b1, int a2, int b2) {
    return (a2 - a1) - (((a2 - a1) % 2 == (b1 + b2) % 2) ? 0 : 1);
  }
}