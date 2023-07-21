import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt();
    for (int tc = 0; tc < T; tc++) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; i++) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[] a) {
    int result = -1;
    Map<Integer, Integer> valueToLastIndex = new HashMap<>();
    for (int i = 0; i < a.length; i++) {
      if (valueToLastIndex.containsKey(a[i])
          && (result == -1 || i - valueToLastIndex.get(a[i]) + 1 < result)) {
        result = i - valueToLastIndex.get(a[i]) + 1;
      }

      valueToLastIndex.put(a[i], i);
    }

    return result;
  }
}
