import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

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

    System.out.println(solve(a));
  }

  static long solve(int[] a) {
    int[] leftCounts = buildCounts(a);
    int[] rightCounts = reverse(buildCounts(reverse(a)));

    long result = 0;
    FenwickTree fenwickTree = new FenwickTree(a.length);
    for (int i = 0; i < a.length; ++i) {
      result += i - fenwickTree.computePrefixSum(rightCounts[i]);
      fenwickTree.add(leftCounts[i], 1);
    }

    return result;
  }

  static int[] reverse(int[] x) {
    return IntStream.range(0, x.length).map(i -> x[x.length - 1 - i]).toArray();
  }

  static int[] buildCounts(int[] x) {
    int[] result = new int[x.length];
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int i = 0; i < result.length; ++i) {
      valueToCount.put(x[i], valueToCount.getOrDefault(x[i], 0) + 1);
      result[i] = valueToCount.get(x[i]);
    }

    return result;
  }
}

class FenwickTree {
  int[] a;

  FenwickTree(int size) {
    a = new int[Integer.highestOneBit(size) * 2 + 1];
  }

  void add(int pos, int delta) {
    while (pos < a.length) {
      a[pos] += delta;
      pos += pos & -pos;
    }
  }

  int computePrefixSum(int pos) {
    int result = 0;
    while (pos != 0) {
      result += a[pos];
      pos -= pos & -pos;
    }

    return result;
  }
}
