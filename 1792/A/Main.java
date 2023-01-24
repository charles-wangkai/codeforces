import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] h = new int[n];
      for (int i = 0; i < h.length; ++i) {
        h[i] = sc.nextInt();
      }

      System.out.println(solve(h));
    }

    sc.close();
  }

  static int solve(int[] h) {
    Arrays.sort(h);

    int result = h.length;
    int pairNum = 0;
    int rest = 0;
    for (int i = 0; i < h.length; ++i) {
      pairNum += Math.max(0, h[i] - rest);
      rest = Math.abs(rest - h[i]);

      result = Math.min(result, pairNum + (h.length - 1 - i));
    }

    return result;
  }
}
