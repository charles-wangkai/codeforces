import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

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
    int[] sorted = Arrays.stream(h).filter(hi -> hi >= h[k - 1]).distinct().sorted().toArray();

    return IntStream.range(1, sorted.length).allMatch(i -> sorted[i] - sorted[0] <= sorted[i - 1]);
  }
}