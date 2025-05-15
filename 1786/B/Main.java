import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int w = sc.nextInt();
      int h = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b, w, h) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a, int[] b, int w, int h) {
    int minShift = Integer.MIN_VALUE;
    int maxShift = Integer.MAX_VALUE;
    for (int i = 0; i < a.length; ++i) {
      minShift = Math.max(minShift, b[i] + h - w - a[i]);
      maxShift = Math.min(maxShift, b[i] - h + w - a[i]);
    }

    return minShift <= maxShift;
  }
}