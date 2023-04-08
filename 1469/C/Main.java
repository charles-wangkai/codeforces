import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] h = new int[n];
      for (int i = 0; i < h.length; ++i) {
        h[i] = sc.nextInt();
      }

      System.out.println(solve(h, k) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] h, int k) {
    int prevMin = h[0];
    int prevMax = h[0];
    for (int i = 1; i < h.length; ++i) {
      int min = Math.max(prevMin - k + 1, h[i]);
      int max = Math.min(prevMax + k - 1, h[i] + k - 1);
      if (min > max) {
        return false;
      }

      prevMin = min;
      prevMax = max;
    }

    return h[h.length - 1] >= prevMin && h[h.length - 1] <= prevMax;
  }
}
