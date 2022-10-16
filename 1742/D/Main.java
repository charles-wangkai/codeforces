import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[] a) {
    Map<Integer, Integer> valueToMaxIndex = new HashMap<>();
    for (int i = 0; i < a.length; ++i) {
      valueToMaxIndex.put(a[i], i);
    }

    int result = -1;
    for (int value1 : valueToMaxIndex.keySet()) {
      for (int value2 : valueToMaxIndex.keySet()) {
        if (gcd(value1, value2) == 1) {
          result = Math.max(result, valueToMaxIndex.get(value1) + valueToMaxIndex.get(value2) + 2);
        }
      }
    }

    return result;
  }

  static int gcd(int x, int y) {
    return (y == 0) ? x : gcd(y, x % y);
  }
}
