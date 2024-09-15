import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int q = sc.nextInt();
      int[] b = new int[m];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }
      int[] a = new int[q];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(n, b, a));
    }

    sc.close();
  }

  static int solve(int n, int[] b, int[] a) {
    int min = Math.min(b[0], b[1]);
    int max = Math.max(b[0], b[1]);
    if (a[0] < min) {
      return min - 1;
    }
    if (a[0] > max) {
      return n - max;
    }

    return (max - min) / 2;
  }
}