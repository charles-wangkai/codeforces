import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int k = sc.nextInt();
      int w = sc.nextInt();
      int[] a = new int[w];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(n, m, k, a));
    }

    sc.close();
  }

  static long solve(int n, int m, int k, int[] a) {
    List<Integer> freqs = new ArrayList<>();
    for (int r = 0; r < n; ++r) {
      for (int c = 0; c < m; ++c) {
        freqs.add(computeFreq(k, n, r) * computeFreq(k, m, c));
      }
    }
    Collections.sort(freqs);

    int[] heights = Arrays.copyOf(a, n * m);
    Arrays.sort(heights);

    return IntStream.range(0, heights.length)
        .mapToLong(i -> (long) heights[i] * freqs.get(i))
        .sum();
  }

  static int computeFreq(int k, int length, int position) {
    return Math.min(length - k, position) - Math.max(0, position - k + 1) + 1;
  }
}