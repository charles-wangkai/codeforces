import java.util.Arrays;
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
    long[] scores = new long[a.length];
    for (int i = scores.length - 1; i >= 0; --i) {
      scores[i] = a[i] + ((i + a[i] >= a.length) ? 0 : scores[i + a[i]]);
    }

    return Arrays.stream(scores).max().getAsLong();
  }
}
