import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] d = new int[n];
      for (int i = 0; i < d.length; ++i) {
        d[i] = sc.nextInt();
      }
      int[] l = new int[n];
      int[] r = new int[n];
      for (int i = 0; i < n; ++i) {
        l[i] = sc.nextInt();
        r[i] = sc.nextInt();
      }

      System.out.println(solve(d, l, r));
    }

    sc.close();
  }

  static String solve(int[] d, int[] l, int[] r) {
    int n = d.length;

    int[] mins = new int[n + 1];
    int[] maxs = new int[n + 1];
    for (int i = 1; i <= n; ++i) {
      if (d[i - 1] == 0) {
        mins[i] = mins[i - 1];
        maxs[i] = maxs[i - 1];
      } else if (d[i - 1] == 1) {
        mins[i] = mins[i - 1] + 1;
        maxs[i] = maxs[i - 1] + 1;
      } else {
        mins[i] = mins[i - 1];
        maxs[i] = maxs[i - 1] + 1;
      }

      mins[i] = Math.max(mins[i], l[i - 1]);
      maxs[i] = Math.min(maxs[i], r[i - 1]);
      if (mins[i] > maxs[i]) {
        return "-1";
      }
    }

    int[] h = new int[n + 1];
    h[n] = mins[n];
    for (int i = n - 1; i >= 1; --i) {
      if (d[i] == -1) {
        if (h[i + 1] >= mins[i] && h[i + 1] <= maxs[i]) {
          h[i] = h[i + 1];
        } else {
          h[i] = h[i + 1] - 1;
        }
      } else {
        h[i] = h[i + 1] - d[i];
      }
    }

    return IntStream.range(1, h.length)
        .map(i -> h[i] - h[i - 1])
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}