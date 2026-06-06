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

  static int solve(int[] a) {
    Map<Integer, Integer> valueToCount = new HashMap<>();
    Map<Integer, Integer> valueToOperationNum = new HashMap<>();
    for (int i = 0; i < a.length; ++i) {
      int value = a[i];
      int operationNum = 0;
      while (true) {
        if (valueToCount.getOrDefault(value, 0) == i) {
          valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
          valueToOperationNum.put(value, valueToOperationNum.getOrDefault(value, 0) + operationNum);
        }

        if (value == ((a[i] == 1) ? 2 : 1)) {
          break;
        }

        if (value % 2 == 0) {
          value /= 2;
        } else {
          ++value;
        }
        ++operationNum;
      }
    }

    return valueToCount.keySet().stream()
        .filter(value -> valueToCount.get(value) == a.length)
        .mapToInt(valueToOperationNum::get)
        .min()
        .getAsInt();
  }
}