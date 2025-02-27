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

  static String solve(int[] a) {
    int maxDelta = 0;
    int l = 1;
    int r = 1;
    for (int i = 0; i < a.length; ++i) {
      int delta = 0;
      for (int j = i + 1; j < a.length; ++j) {
        if (a[j] < a[i]) {
          ++delta;

          if (delta > maxDelta) {
            maxDelta = delta;
            l = i + 1;
            r = j + 1;
          }
        } else if (a[j] > a[i]) {
          --delta;
        }
      }
    }

    return "%d %d".formatted(l, r);
  }
}