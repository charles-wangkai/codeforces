import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < a.length; ++i) {
      a[i] = Integer.parseInt(st.nextToken());
    }
    int[] l = new int[m];
    int[] r = new int[m];
    for (int i = 0; i < m; ++i) {
      st = new StringTokenizer(br.readLine());
      l[i] = Integer.parseInt(st.nextToken());
      r[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solve(a, l, r));
  }

  static String solve(int[] a, int[] l, int[] r) {
    int negativeCount = (int) Arrays.stream(a).filter(ai -> ai == -1).count();
    int positiveCount = a.length - negativeCount;

    return IntStream.range(0, l.length)
        .map(
            i ->
                ((r[i] - l[i] + 1) % 2 == 0
                        && Math.min(negativeCount, positiveCount) >= (r[i] - l[i] + 1) / 2)
                    ? 1
                    : 0)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }
}