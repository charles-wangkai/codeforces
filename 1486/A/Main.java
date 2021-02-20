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

      System.out.println(solve(h) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] h) {
    long[] heights = Arrays.stream(h).asLongStream().toArray();
    for (int i = 0; i < heights.length; ++i) {
      if (heights[i] < i) {
        return false;
      }

      if (i != heights.length - 1) {
        heights[i + 1] += heights[i] - i;
      }
    }

    return true;
  }
}
