import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, x));
    }

    sc.close();
  }

  static int solve(int[] a, int x) {
    Arrays.sort(a);

    int result = 0;
    int count = 0;
    for (int i = a.length - 1; i >= 0; --i) {
      ++count;
      if (a[i] * count >= x) {
        ++result;
        count = 0;
      }
    }

    return result;
  }
}