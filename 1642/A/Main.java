import java.util.Scanner;

public class Main {
  static final int POINT_NUM = 3;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int[] x = new int[POINT_NUM];
      int[] y = new int[POINT_NUM];
      for (int i = 0; i < POINT_NUM; ++i) {
        x[i] = sc.nextInt();
        y[i] = sc.nextInt();
      }

      System.out.println(solve(x, y));
    }

    sc.close();
  }

  static int solve(int[] x, int[] y) {
    for (int i = 0; i < x.length; ++i) {
      if (y[i] == y[(i + 1) % y.length] && y[(i + 2) % y.length] < y[i]) {
        return Math.abs(x[i] - x[(i + 1) % x.length]);
      }
    }

    return 0;
  }
}