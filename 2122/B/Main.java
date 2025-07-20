import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
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
      int[] b = new int[n];
      int[] c = new int[n];
      int[] d = new int[n];
      for (int i = 0; i < n; ++i) {
        st = new StringTokenizer(br.readLine());
        a[i] = Integer.parseInt(st.nextToken());
        b[i] = Integer.parseInt(st.nextToken());
        c[i] = Integer.parseInt(st.nextToken());
        d[i] = Integer.parseInt(st.nextToken());
      }

      System.out.println(solve(a, b, c, d));
    }
  }

  static long solve(int[] a, int[] b, int[] c, int[] d) {
    return IntStream.range(0, a.length)
        .map(i -> (d[i] >= b[i]) ? Math.max(0, a[i] - c[i]) : (a[i] + (b[i] - d[i])))
        .asLongStream()
        .sum();
  }
}