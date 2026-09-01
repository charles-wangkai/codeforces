import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] l = new int[n];
      int[] r = new int[n];
      int[] u = new int[n];
      int[] v = new int[n];
      for (int i = 0; i < n; ++i) {
        l[i] = sc.nextInt();
        r[i] = sc.nextInt();
        u[i] = sc.nextInt();
        v[i] = sc.nextInt();
      }

      System.out.println(solve(l, r, u, v));
    }

    sc.close();
  }

  static int solve(int[] l, int[] r, int[] u, int[] v) {
    int n = l.length;

    for (int m = n; ; --m) {
      if (check(l, r, u, v, m)) {
        return m;
      }
    }
  }

  static boolean check(int[] l, int[] r, int[] u, int[] v, int m) {
    int n = l.length;

    if (m == 0) {
      return true;
    }

    int count = 0;
    for (int i = 0; i < n; ++i) {
      int leftRank = count + 1;
      int rightRank = m - count;

      if (!(leftRank >= l[i] && leftRank <= r[i]) && !(rightRank >= u[i] && rightRank <= v[i])) {
        ++count;
        if (count == m) {
          return true;
        }
      }
    }

    return false;
  }
}