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
    int start = Arrays.stream(a).max().getAsInt();
    int min = start;
    int max = start + k;
    for (int ai : a) {
      int left = (start - ai) / (2 * k) * (2 * k) + ai;
      int right = left + k;
      if (right <= start) {
        left += 2 * k;
        right += 2 * k;
      }

      if (right <= min || left >= max) {
        return -1;
      }

      min = Math.max(min, left);
      max = Math.min(max, right);
    }

    return (min == max) ? -1 : min;
  }
}