import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int x = sc.nextInt();
      int[] h = new int[2 * n];
      for (int i = 0; i < h.length; ++i) {
        h[i] = sc.nextInt();
      }

      System.out.println(solve(h, x) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] h, int x) {
    Arrays.sort(h);

    return IntStream.range(0, h.length / 2).allMatch(i -> h[i] + x <= h[i + h.length / 2]);
  }
}