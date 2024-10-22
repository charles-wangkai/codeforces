import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static int solve(int[] a, int k) {
    Arrays.sort(a);

    int result = 0;
    for (int i = 0; ; ++i) {
      if (i != 0) {
        ++result;
      }

      long diff = (a[i] - ((i == 0) ? 0L : a[i - 1])) * (a.length - i);
      if (diff >= k) {
        result += k;

        return result;
      }

      result += diff;
      k -= diff;
    }
  }
}