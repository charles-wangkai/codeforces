import java.util.Scanner;
import java.util.stream.IntStream;

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
    return Math.max(
        IntStream.range(0, a.length).map(i -> a[i] - ((i == 0) ? 0 : a[i - 1])).max().getAsInt(),
        2 * (x - a[a.length - 1]));
  }
}