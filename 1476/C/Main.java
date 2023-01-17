import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] c = new int[n];
      for (int i = 0; i < c.length; ++i) {
        c[i] = sc.nextInt();
      }
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(c, a, b));
    }

    sc.close();
  }

  static long solve(int[] c, int[] a, int[] b) {
    long result = 2;
    long prev = -1;
    for (int i = 1; i < a.length; ++i) {
      if (a[i] == b[i]) {
        prev = 1;
      } else {
        if (i != 1) {
          prev +=
              Math.abs(1 - Math.min(a[i], b[i])) + Math.abs(c[i - 1] - Math.max(a[i], b[i])) + 2;
        }
        prev = Math.max(prev, Math.abs(a[i] - b[i]) + 1);
      }

      result = Math.max(result, prev + c[i]);
    }

    return result;
  }
}
