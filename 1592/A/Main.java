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
      int H = Integer.parseInt(st.nextToken());
      int[] a = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < a.length; ++i) {
        a[i] = Integer.parseInt(st.nextToken());
      }

      System.out.println(solve(a, H));
    }
  }

  static int solve(int[] a, int H) {
    int[] sorted =
        Arrays.stream(a).boxed().sorted(Comparator.reverseOrder()).mapToInt(x -> x).toArray();

    int result = H / (sorted[0] + sorted[1]) * 2;
    H %= sorted[0] + sorted[1];
    if (H > sorted[0]) {
      result += 2;
    } else if (H != 0) {
      ++result;
    }

    return result;
  }
}
