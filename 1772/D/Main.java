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

  static int solve(int[] a) {
    int lower = 0;
    int upper = 1_000_000_000;
    for (int i = 0; i < a.length - 1; ++i) {
      if (a[i] < a[i + 1]) {
        upper = Math.min(upper, (a[i] + a[i + 1]) / 2);
      } else if (a[i] > a[i + 1]) {
        lower = Math.max(lower, (a[i] + a[i + 1] + 1) / 2);
      }

      if (lower > upper) {
        return -1;
      }
    }

    return lower;
  }
}
