import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int q = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < q; ++tc) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int[] a = new int[n];
      int[] b = new int[n];
      for (int i = 0; i < n; ++i) {
        st = new StringTokenizer(br.readLine());
        a[i] = Integer.parseInt(st.nextToken());
        b[i] = Integer.parseInt(st.nextToken());
      }

      System.out.println(solve(a, b));
    }
  }

  static long solve(int[] a, int[] b) {
    Map<Integer, Long> heightToCost = Map.of(-1, 0L);
    for (int i = 0; i < a.length; ++i) {
      Map<Integer, Long> nextHeightToCost = new HashMap<>();
      for (int height : heightToCost.keySet()) {
        for (int d = 0; d <= 2; ++d) {
          int nextHeight = a[i] + d;
          if (nextHeight != height) {
            nextHeightToCost.put(
                nextHeight,
                Math.min(
                    nextHeightToCost.getOrDefault(nextHeight, Long.MAX_VALUE),
                    heightToCost.get(height) + b[i] * d));
          }
        }
      }

      heightToCost = nextHeightToCost;
    }

    return heightToCost.values().stream().mapToLong(Long::longValue).min().getAsLong();
  }
}