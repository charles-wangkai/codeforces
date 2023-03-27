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
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b) ? "Yes" : "No");
    }

    sc.close();
  }

  static boolean solve(int[] a, int[] b) {
    return IntStream.range(0, a.length)
        .allMatch(
            i ->
                (a[i] <= a[a.length - 1] && b[i] <= b[a.length - 1])
                    || (a[i] <= b[a.length - 1] && b[i] <= a[a.length - 1]));
  }
}
