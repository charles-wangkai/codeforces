import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int x0 = sc.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < n; ++i) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    System.out.println(solve(a, b, x0));

    sc.close();
  }

  static int solve(int[] a, int[] b, int x0) {
    int min = Integer.MIN_VALUE;
    int max = Integer.MAX_VALUE;
    for (int i = 0; i < a.length; ++i) {
      min = Math.max(min, Math.min(a[i], b[i]));
      max = Math.min(max, Math.max(a[i], b[i]));
    }

    if (min > max) {
      return -1;
    }
    if (x0 < min) {
      return min - x0;
    }
    if (x0 > max) {
      return x0 - max;
    }

    return 0;
  }
}