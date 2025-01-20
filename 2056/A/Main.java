import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] x = new int[n];
      int[] y = new int[n];
      for (int i = 0; i < n; ++i) {
        x[i] = sc.nextInt();
        y[i] = sc.nextInt();
      }

      System.out.println(solve(x, y, m));
    }

    sc.close();
  }

  static int solve(int[] x, int[] y, int m) {
    return 4 * m + IntStream.range(1, x.length).map(i -> 2 * x[i] + 2 * y[i]).sum();
  }
}