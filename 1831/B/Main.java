import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

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
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static int solve(int[] a, int[] b) {
    Map<Integer, Integer> aValueToMaxLength = buildValueToMaxLength(a);
    Map<Integer, Integer> bValueToMaxLength = buildValueToMaxLength(b);

    return Stream.concat(aValueToMaxLength.keySet().stream(), bValueToMaxLength.keySet().stream())
        .mapToInt(
            value ->
                aValueToMaxLength.getOrDefault(value, 0) + bValueToMaxLength.getOrDefault(value, 0))
        .max()
        .getAsInt();
  }

  static Map<Integer, Integer> buildValueToMaxLength(int[] values) {
    Map<Integer, Integer> valueToMaxLength = new HashMap<>();
    int prev = -1;
    int length = 0;
    for (int value : values) {
      if (value == prev) {
        ++length;
      } else {
        length = 1;
      }
      valueToMaxLength.put(value, Math.max(valueToMaxLength.getOrDefault(value, 0), length));

      prev = value;
    }

    return valueToMaxLength;
  }
}
