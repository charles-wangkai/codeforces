import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      int[] b = new int[n];
      for (int i = 0; i < n; ++i) {
        a[i] = sc.nextInt();
        b[i] = sc.nextInt();
      }
      int[] tm = new int[n];
      for (int i = 0; i < tm.length; ++i) {
        tm[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, tm));
    }

    sc.close();
  }

  static int solve(int[] a, int[] b, int[] tm) {
    int time = 0;
    for (int i = 0; i < a.length; ++i) {
      time += a[i] - ((i == 0) ? 0 : b[i - 1]) + tm[i];

      if (i != a.length - 1) {
        time = Math.max(b[i], time + (b[i] - a[i] + 1) / 2);
      }
    }

    return time;
  }
}
