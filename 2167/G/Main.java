import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < t; ++tc) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int[] a = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < a.length; ++i) {
        a[i] = Integer.parseInt(st.nextToken());
      }
      int[] c = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < c.length; ++i) {
        c[i] = Integer.parseInt(st.nextToken());
      }

      System.out.println(solve(a, c));
    }
  }

  static long solve(int[] a, int[] c) {
    int[] sorted = Arrays.stream(a).sorted().distinct().toArray();
    Map<Integer, Integer> valueToIndex =
        IntStream.range(0, sorted.length).boxed().collect(Collectors.toMap(i -> sorted[i], i -> i));

    long[] dp = new long[sorted.length];
    Arrays.fill(dp, Long.MAX_VALUE);
    dp[0] = 0;

    for (int i = 0; i < a.length; ++i) {
      long[] nextDp = new long[sorted.length];
      Arrays.fill(nextDp, Long.MAX_VALUE);

      int value = valueToIndex.get(a[i]);

      for (int last = 0; last < dp.length; ++last) {
        if (dp[last] != Long.MAX_VALUE) {
          if (value >= last) {
            nextDp[value] = Math.min(nextDp[value], dp[last]);
          }

          nextDp[last] = Math.min(nextDp[last], dp[last] + c[i]);
        }
      }

      dp = nextDp;
    }

    return Arrays.stream(dp).min().getAsLong();
  }
}