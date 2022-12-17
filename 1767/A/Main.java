import java.util.Arrays;
import java.util.Scanner;

public class Main {
  static final int VERTEX_NUM = 3;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int[] x = new int[VERTEX_NUM];
      int[] y = new int[VERTEX_NUM];
      for (int i = 0; i < VERTEX_NUM; ++i) {
        x[i] = sc.nextInt();
        y[i] = sc.nextInt();
      }

      System.out.println(solve(x, y) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] x, int[] y) {
    return Arrays.stream(x).distinct().count() == x.length
        || Arrays.stream(y).distinct().count() == y.length;
  }
}
