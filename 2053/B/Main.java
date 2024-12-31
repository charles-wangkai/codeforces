import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
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
      int[] l = new int[n];
      int[] r = new int[n];
      for (int i = 0; i < n; ++i) {
        st = new StringTokenizer(br.readLine());
        l[i] = Integer.parseInt(st.nextToken());
        r[i] = Integer.parseInt(st.nextToken());
      }

      System.out.println(solve(l, r));
    }
  }

  static String solve(int[] l, int[] r) {
    Map<Integer, Integer> fixedValueToCount = new HashMap<>();
    for (int i = 0; i < l.length; ++i) {
      if (l[i] == r[i]) {
        fixedValueToCount.put(l[i], fixedValueToCount.getOrDefault(l[i], 0) + 1);
      }
    }

    int[] sortedFixedValues =
        fixedValueToCount.keySet().stream().mapToInt(Integer::intValue).sorted().toArray();

    return IntStream.range(0, l.length)
        .mapToObj(
            i ->
                (l[i] == r[i])
                    ? (fixedValueToCount.get(l[i]) == 1)
                    : (r[i] - l[i]
                        > findRightIndex(sortedFixedValues, r[i])
                            - findLeftIndex(sortedFixedValues, l[i])))
        .map(x -> x ? 1 : 0)
        .map(String::valueOf)
        .collect(Collectors.joining());
  }

  static int findLeftIndex(int[] sortedFixedValues, int minValue) {
    int result = sortedFixedValues.length;
    int lower = 0;
    int upper = sortedFixedValues.length - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (sortedFixedValues[middle] >= minValue) {
        result = middle;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }

  static int findRightIndex(int[] sortedFixedValues, int maxValue) {
    int result = -1;
    int lower = 0;
    int upper = sortedFixedValues.length - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (sortedFixedValues[middle] <= maxValue) {
        result = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return result;
  }
}
