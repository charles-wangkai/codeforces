import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int f = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();
      int[] m = new int[n];
      for (int i = 0; i < m.length; ++i) {
        m[i] = sc.nextInt();
      }

      System.out.println(solve(m, f, a, b) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] m, int f, int a, int b) {
    for (int i = 0; i < m.length; ++i) {
      f -= Math.min((long) (m[i] - ((i == 0) ? 0 : m[i - 1])) * a, b);
      if (f <= 0) {
        return false;
      }
    }

    return true;
  }
}