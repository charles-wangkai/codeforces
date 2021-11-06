import java.util.Arrays;
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

  static long solve(int[] a) {
    long total = Arrays.stream(a).asLongStream().sum();
    if (total * 2 % a.length != 0) {
      return 0;
    }

    int sum = (int) (total * 2 / a.length);

    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int value : a) {
      valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
    }

    long result = 0;
    for (int value : valueToCount.keySet()) {
      int other = sum - value;
      if (other > value) {
        result += (long) valueToCount.get(value) * valueToCount.getOrDefault(other, 0);
      } else if (other == value) {
        result += valueToCount.get(value) * (valueToCount.get(value) - 1L) / 2;
      }
    }

    return result;
  }
}
