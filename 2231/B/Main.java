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

      System.out.println(solve(a) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a) {
    int k = 0;
    int max = -1;
    for (int ai : a) {
      k = Math.max(k, max - ai);
      max = Math.max(max, ai);
    }

    int prev = -1;
    for (int ai : a) {
      if (ai < prev) {
        ai += k;
      }
      if (ai < prev) {
        return false;
      }

      prev = ai;
    }

    return true;
  }
}