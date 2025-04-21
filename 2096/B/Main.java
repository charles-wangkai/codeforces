import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < t; ++tc) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      int[] l = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < l.length; ++i) {
        l[i] = Integer.parseInt(st.nextToken());
      }
      int[] r = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < r.length; ++i) {
        r[i] = Integer.parseInt(st.nextToken());
      }

      System.out.println(solve(l, r, k));
    }
  }

  static long solve(int[] l, int[] r, int k) {
    int n = l.length;

    int[] mins = new int[n];
    int[] maxs = new int[n];
    for (int i = 0; i < n; ++i) {
      if (l[i] < r[i]) {
        mins[i] = l[i];
        maxs[i] = r[i];
      } else {
        mins[i] = r[i];
        maxs[i] = l[i];
      }
    }

    return Arrays.stream(maxs).asLongStream().sum()
        + Arrays.stream(mins)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .asLongStream()
            .limit(k - 1)
            .sum()
        + 1;
  }
}