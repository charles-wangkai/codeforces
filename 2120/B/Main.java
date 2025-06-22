import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int s = sc.nextInt();
      int[] dx = new int[n];
      int[] dy = new int[n];
      int[] x = new int[n];
      int[] y = new int[n];
      for (int i = 0; i < n; ++i) {
        dx[i] = sc.nextInt();
        dy[i] = sc.nextInt();
        x[i] = sc.nextInt();
        y[i] = sc.nextInt();
      }

      System.out.println(solve(dx, dy, x, y, s));
    }

    sc.close();
  }

  static int solve(int[] dx, int[] dy, int[] x, int[] y, int s) {
    return (int)
        IntStream.range(0, dx.length)
            .filter(i -> ((dx[i] == -1) ? x[i] : (s - x[i])) == ((dy[i] == -1) ? y[i] : (s - y[i])))
            .count();
  }
}