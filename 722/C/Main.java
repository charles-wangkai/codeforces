import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.NavigableMap;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[] a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < a.length; ++i) {
      a[i] = Integer.parseInt(st.nextToken());
    }
    int[] p = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < p.length; ++i) {
      p[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solve(a, p));
  }

  static String solve(int[] a, int[] p) {
    long[] result = new long[a.length];
    NavigableMap<Range, Long> rangeToSum = new TreeMap<>(Comparator.comparing(Range::begin));
    long maxSum = 0;
    for (int i = result.length - 1; i >= 0; --i) {
      result[i] = maxSum;

      int begin = p[i] - 1;
      int end = p[i] - 1;
      long sum = a[p[i] - 1];

      Range lower = rangeToSum.lowerKey(new Range(begin, end));
      if (lower != null && lower.end() == begin - 1) {
        begin = lower.begin();
        sum += rangeToSum.get(lower);
        rangeToSum.remove(lower);
      }

      Range upper = rangeToSum.higherKey(new Range(begin, end));
      if (upper != null && upper.begin() == end + 1) {
        end = upper.end();
        sum += rangeToSum.get(upper);
        rangeToSum.remove(upper);
      }

      maxSum = Math.max(maxSum, sum);
      rangeToSum.put(new Range(begin, end), sum);
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}

record Range(int begin, int end) {}
