import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < a.length; ++i) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(solve(a, k));
  }

  static String solve(int[] a, int k) {
    int l = -1;
    int r = -2;
    Map<Integer, Integer> valueToCount = new HashMap<>();
    int endIndex = -1;
    for (int beginIndex = 0; beginIndex < a.length; ++beginIndex) {
      while (endIndex != a.length - 1
          && (valueToCount.size() != k || valueToCount.containsKey(a[endIndex + 1]))) {
        ++endIndex;
        updateMap(valueToCount, a[endIndex], 1);
      }

      if (endIndex - beginIndex > r - l) {
        l = beginIndex + 1;
        r = endIndex + 1;
      }

      updateMap(valueToCount, a[beginIndex], -1);
    }

    return "%d %d".formatted(l, r);
  }

  static void updateMap(Map<Integer, Integer> valueToCount, int value, int delta) {
    valueToCount.put(value, valueToCount.getOrDefault(value, 0) + delta);
    valueToCount.remove(value, 0);
  }
}