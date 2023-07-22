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

    int maxLength = 1;
    int beginIndex = 0;
    for (int i = 1; i < a.length; ++i) {
      if (a[i] - a[i - 1] <= k) {
        maxLength = Math.max(maxLength, i - beginIndex + 1);
      } else {
        beginIndex = i;
      }
    }

    return a.length - maxLength;
  }
}
