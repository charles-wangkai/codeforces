import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

  static String solve(int[] h) {
    return IntStream.range(0, h.length)
        .mapToLong(i -> computeMaxTotalVolume(h, i))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }

  static long computeMaxTotalVolume(int[] h, int index) {
    int n = h.length;

    int[] w = new int[h.length];
    for (int i = 0; i < n - 1; ++i) {
      int pos = (index + i) % n;
      w[(pos + 1) % n] = Math.max(w[pos], h[pos]);
    }
    for (int i = 1; i < n; ++i) {
      int pos = Math.floorMod(index - i, n);
      if (w[pos] != w[(pos + 1) % n] && w[pos] > h[pos]) {
        w[pos] = Math.max(h[pos], w[(pos + 1) % n]);
      }
    }

    return Arrays.stream(w).asLongStream().sum();
  }
}