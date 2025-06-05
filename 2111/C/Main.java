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

      System.out.println(solve(a));
    }

    sc.close();
  }

  static long solve(int[] a) {
    long result = Long.MAX_VALUE;
    int prev = -1;
    int count = 0;
    for (int i = 0; i <= a.length; ++i) {
      if (i != a.length && a[i] == prev) {
        ++count;
      } else {
        if (count != 0) {
          result = Math.min(result, (long) prev * (a.length - count));
        }

        if (i != a.length) {
          prev = a[i];
          count = 1;
        }
      }
    }

    return result;
  }
}