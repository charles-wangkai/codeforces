import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
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
      long k = Long.parseLong(st.nextToken());
      int[] q = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < q.length; ++i) {
        q[i] = Integer.parseInt(st.nextToken());
      }
      int[] r = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < r.length; ++i) {
        r[i] = Integer.parseInt(st.nextToken());
      }

      System.out.println(solve(q, r, k));
    }
  }

  static int solve(int[] q, int[] r, long k) {
    Arrays.sort(q);
    Arrays.sort(r);

    int result = 0;
    int lower = 1;
    int upper = q.length;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;

      if (check(q, r, k, middle)) {
        result = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return result;
  }

  static boolean check(int[] q, int[] r, long k, int size) {
    int[] quotients =
        IntStream.range(0, size)
            .map(i -> q[i])
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

    for (int i = 0; i < size; ++i) {
      int y = r[i] + 1;
      long maxQuotient = (k - r[i]) / y;

      if (maxQuotient < quotients[i]) {
        return false;
      }
    }

    return true;
  }
}