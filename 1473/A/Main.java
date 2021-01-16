import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int d = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, d) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a, int d) {
    Arrays.sort(a);

    return Math.min(a[a.length - 1], a[0] + a[1]) <= d;
  }
}
