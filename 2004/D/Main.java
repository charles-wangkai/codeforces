import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
    int t = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < t; ++tc) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int q = Integer.parseInt(st.nextToken());
      String[] types = new String[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < types.length; ++i) {
        types[i] = st.nextToken();
      }
      int[] x = new int[q];
      int[] y = new int[q];
      for (int i = 0; i < q; ++i) {
        st = new StringTokenizer(br.readLine());
        x[i] = Integer.parseInt(st.nextToken());
        y[i] = Integer.parseInt(st.nextToken());
      }

      System.out.println(solve(types, x, y));
    }
  }

  static String solve(String[] types, int[] x, int[] y) {
    @SuppressWarnings("unchecked")
    List<Integer>[] candidateLists = new List[types.length];
    for (int i = 0; i < candidateLists.length; ++i) {
      candidateLists[i] = new ArrayList<>();
    }

    Map<String, Integer> leftTypeToLastIndex = new HashMap<>();
    for (int i = 0; i < types.length; ++i) {
      for (String leftType : leftTypeToLastIndex.keySet()) {
        if (hasSameColor(leftType, types[i])) {
          candidateLists[i].add(leftTypeToLastIndex.get(leftType));
        }
      }
      leftTypeToLastIndex.put(types[i], i);
    }

    Map<String, Integer> rightTypeToLastIndex = new HashMap<>();
    for (int i = types.length - 1; i >= 0; --i) {
      for (String rightType : rightTypeToLastIndex.keySet()) {
        if (hasSameColor(rightType, types[i])) {
          candidateLists[i].add(rightTypeToLastIndex.get(rightType));
        }
      }
      rightTypeToLastIndex.put(types[i], i);
    }

    return IntStream.range(0, x.length)
        .map(
            i -> {
              int distance = search(types, candidateLists, y[i] - 1, x[i] - 1, 4);

              return (distance == Integer.MAX_VALUE) ? -1 : distance;
            })
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }

  static int search(
      String[] types, List<Integer>[] candidateLists, int target, int node, int rest) {
    if (rest == 0) {
      return Integer.MAX_VALUE;
    }

    if (hasSameColor(types[node], types[target])) {
      return Math.abs(node - target);
    }

    int result = Integer.MAX_VALUE;
    for (int candidate : candidateLists[node]) {
      int distance = search(types, candidateLists, target, candidate, rest - 1);
      if (distance != Integer.MAX_VALUE) {
        result = Math.min(result, Math.abs(node - candidate) + distance);
      }
    }

    return result;
  }

  static boolean hasSameColor(String type1, String type2) {
    return type1.charAt(0) == type2.charAt(0)
        || type1.charAt(0) == type2.charAt(1)
        || type1.charAt(1) == type2.charAt(0)
        || type1.charAt(1) == type2.charAt(1);
  }
}