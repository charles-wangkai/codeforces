import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, x));
    }

    sc.close();
  }

  static int solve(int[] a, int x) {
    int result = 0;
    int min = a[0];
    int max = a[0];
    for (int i = 1; i < a.length; ++i) {
      min = Math.min(min, a[i]);
      max = Math.max(max, a[i]);

      if (max - min > x * 2) {
        ++result;
        min = a[i];
        max = a[i];
      }
    }

    return result;
  }
}