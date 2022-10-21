import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] x = new int[m];
      int[] y = new int[m];
      for (int i = 0; i < m; ++i) {
        x[i] = sc.nextInt();
        y[i] = sc.nextInt();
      }

      System.out.println(solve(n, x, y) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int n, int[] x, int[] y) {
    return x.length != n;
  }
}
