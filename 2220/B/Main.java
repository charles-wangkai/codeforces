import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, m) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a, int m) {
    int maxCount = 0;
    int count = 0;
    for (int i = 0; i < a.length; ++i) {
      if (i != 0 && a[i] == a[i - 1]) {
        ++count;
      } else {
        count = 1;
      }

      maxCount = Math.max(maxCount, count);
    }

    return maxCount < m;
  }
}