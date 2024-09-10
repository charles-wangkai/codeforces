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
    int[] binaryIndexedTree = new int[Integer.highestOneBit(a.length) * 2 + 1];
    for (int i = 0; i < a.length; ++i) {
      result += i - computeSum(binaryIndexedTree, rightCounts[i]);
      add(binaryIndexedTree, leftCounts[i], 1);
    }

    return result;
  }

  static void add(int[] binaryIndexedTree, int i, int x) {
    while (i < binaryIndexedTree.length) {
      binaryIndexedTree[i] += x;
      i += i & -i;
    }
  }

  static int computeSum(int[] binaryIndexedTree, int i) {
    int result = 0;
    while (i != 0) {
      result += binaryIndexedTree[i];
      i -= i & -i;
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