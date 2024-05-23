import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Throwable {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int t = Integer.parseInt(st.nextToken());
    for (int tc = 0; tc < t; ++tc) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int[] a = new int[n];
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < a.length; ++i) {
        a[i] = Integer.parseInt(st.nextToken());
      }

      System.out.println(solve(a));
    }
  }

  static long solve(int[] a) {
    return computePairNum(a, 2) + computePairNum(a, 0) + computePairNum(a, 1);
  }

  static long computePairNum(int[] a, int valueOffset) {
    Map<String, Integer> keyToTotal = new HashMap<>();
    Map<String, Map<Integer, Integer>> keyToValueCount = new HashMap<>();
    for (int i = 0; i + 2 < a.length; ++i) {
      String key =
          String.format("%d,%d", a[i + (valueOffset + 1) % 3], a[i + (valueOffset + 2) % 3]);
      int value = a[i + valueOffset];

      keyToTotal.put(key, keyToTotal.getOrDefault(key, 0) + 1);

      keyToValueCount.putIfAbsent(key, new HashMap<>());
      Map<Integer, Integer> valueToCount = keyToValueCount.get(key);
      valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
    }

    long result = 0;
    for (String key : keyToValueCount.keySet()) {
      for (int count : keyToValueCount.get(key).values()) {
        result += (long) count * (keyToTotal.get(key) - count);
      }
    }
    result /= 2;

    return result;
  }
}
