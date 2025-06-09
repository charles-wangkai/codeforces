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

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    int xySum = (a[0] + a[a.length - 1]) / (a.length + 1);
    int x = (a[a.length - 1] - xySum) / (a.length - 1);
    int y = xySum - x;

    return x >= 0
        && y >= 0
        && IntStream.range(0, a.length)
            .allMatch(i -> x * (i + 1L) + (long) y * (a.length - i) == a[i]);
  }
}