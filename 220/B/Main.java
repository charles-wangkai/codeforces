import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
    for (int i = 0; i < a.length; ++i) {
      valueToIndices.putIfAbsent(a[i], new ArrayList<>());
      valueToIndices.get(a[i]).add(i);
    }

    int[] candidates =
        valueToIndices.keySet().stream()
            .filter(value -> valueToIndices.get(value).size() >= value)
            .mapToInt(Integer::intValue)
            .toArray();

    int[] result = new int[l.length];
    int[] sortedQueryIndices =
        IntStream.range(0, l.length)
            .boxed()
            .sorted(Comparator.comparing(i -> l[i]))
            .mapToInt(Integer::intValue)
            .toArray();
    for (int candidate : candidates) {
      List<Integer> indices = valueToIndices.get(candidate);
      int from = 0;
      for (int queryIndex : sortedQueryIndices) {
        while (from != indices.size() && indices.get(from) < l[queryIndex] - 1) {
          ++from;
        }

        int to = from + candidate - 1;
        if (to < indices.size()
            && indices.get(to) <= r[queryIndex] - 1
            && (to == indices.size() - 1 || indices.get(to + 1) > r[queryIndex] - 1)) {
          ++result[queryIndex];
        }
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}