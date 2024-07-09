import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int w = sc.nextInt();
    int h = sc.nextInt();
    int[] widths = new int[n];
    int[] heights = new int[n];
    for (int i = 0; i < n; ++i) {
      widths[i] = sc.nextInt();
      heights[i] = sc.nextInt();
    }

    System.out.println(solve(widths, heights, w, h));

    sc.close();
  }

  static String solve(int[] widths, int[] heights, int w, int h) {
    int[] indices =
        IntStream.range(0, widths.length)
            .filter(i -> widths[i] > w && heights[i] > h)
            .boxed()
            .sorted(Comparator.comparing(i -> widths[i]))
            .mapToInt(Integer::intValue)
            .toArray();
    if (indices.length == 0) {
      return "0";
    }

    int[] dp = new int[indices.length];
    Arrays.fill(dp, 1);
    int[] prevs = new int[dp.length];
    Arrays.fill(prevs, -1);
    for (int i = 0; i < dp.length; ++i) {
      for (int j = 0; j < i; ++j) {
        if (widths[indices[j]] < widths[indices[i]]
            && heights[indices[j]] < heights[indices[i]]
            && dp[j] + 1 > dp[i]) {
          dp[i] = dp[j] + 1;
          prevs[i] = j;
        }
      }
    }

    int current = IntStream.range(0, dp.length).boxed().max(Comparator.comparing(i -> dp[i])).get();
    List<Integer> chain = new ArrayList<>();
    while (current != -1) {
      chain.add(indices[current] + 1);
      current = prevs[current];
    }
    Collections.reverse(chain);

    return "%d\n%s"
        .formatted(
            chain.size(), chain.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }
}