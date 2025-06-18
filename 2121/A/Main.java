import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int s = sc.nextInt();
      int[] x = new int[n];
      for (int i = 0; i < x.length; ++i) {
        x[i] = sc.nextInt();
      }

      System.out.println(solve(x, s));
    }

    sc.close();
  }

  static int solve(int[] x, int s) {
    if (s <= x[0]) {
      return x[x.length - 1] - s;
    }
    if (s >= x[x.length - 1]) {
      return s - x[0];
    }

    return Math.min(s - x[0], x[x.length - 1] - s) + (x[x.length - 1] - x[0]);
  }
}