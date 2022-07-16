import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] u = new int[n];
      for (int i = 0; i < u.length; ++i) {
        u[i] = sc.nextInt();
      }
      int[] a = new int[k];
      int[] b = new int[k];
      for (int i = 0; i < k; ++i) {
        a[i] = sc.nextInt();
        b[i] = sc.nextInt();
      }

      System.out.println(solve(u, a, b));
    }

    sc.close();
  }

  static String solve(int[] u, int[] a, int[] b) {
    Map<Integer, Integer> valueToLeftIndex = new HashMap<>();
    for (int i = 0; i < u.length; ++i) {
      if (!valueToLeftIndex.containsKey(u[i])) {
        valueToLeftIndex.put(u[i], i);
      }
    }

    Map<Integer, Integer> valueToRightIndex = new HashMap<>();
    for (int i = u.length - 1; i >= 0; --i) {
      if (!valueToRightIndex.containsKey(u[i])) {
        valueToRightIndex.put(u[i], i);
      }
    }

    return IntStream.range(0, a.length)
        .mapToObj(
            i ->
                (valueToLeftIndex.getOrDefault(a[i], Integer.MAX_VALUE)
                        < valueToRightIndex.getOrDefault(b[i], Integer.MIN_VALUE))
                    ? "YES"
                    : "NO")
        .collect(Collectors.joining("\n"));
  }
}