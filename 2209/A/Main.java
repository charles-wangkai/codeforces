import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int c = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, c, k));
    }

    sc.close();
  }

  static long solve(int[] a, int c, int k) {
    Arrays.sort(a);

    long result = c;
    for (int ai : a) {
      if (ai <= result) {
        int delta = (int) Math.min(k, result - ai);
        ai += delta;
        k -= delta;

        result += ai;
      }
    }

    return result;
  }
}