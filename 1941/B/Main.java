import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    for (int i = 1; i <= a.length - 2; ++i) {
      a[i] -= 2 * a[i - 1];
      a[i + 1] -= a[i - 1];
      if (a[i] < 0 || a[i + 1] < 0) {
        return false;
      }
    }

    return a[a.length - 2] == 0 && a[a.length - 1] == 0;
  }
}