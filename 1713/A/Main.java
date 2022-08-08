import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] x = new int[n];
      int[] y = new int[n];
      for (int i = 0; i < n; ++i) {
        x[i] = sc.nextInt();
        y[i] = sc.nextInt();
      }

      System.out.println(solve(x, y));
    }

    sc.close();
  }

  static int solve(int[] x, int[] y) {
    return 2
        * (Math.max(0, Arrays.stream(x).max().getAsInt())
            - Math.min(0, Arrays.stream(x).min().getAsInt())
            + Math.max(0, Arrays.stream(y).max().getAsInt())
            - Math.min(0, Arrays.stream(y).min().getAsInt()));
  }
}