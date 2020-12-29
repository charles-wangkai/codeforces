import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] x = new int[n];
      int[] y = new int[n];
      for (int i = 0; i < n; ++i) {
        x[i] = sc.nextInt();
        y[i] = sc.nextInt();
      }

      System.out.println(solve(x, y, k));
    }

    sc.close();
  }

  static int solve(int[] x, int[] y, int k) {
    return IntStream.range(0, x.length)
            .anyMatch(
                i ->
                    IntStream.range(0, x.length)
                        .allMatch(j -> Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]) <= k))
        ? 1
        : -1;
  }
}
