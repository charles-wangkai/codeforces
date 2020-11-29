import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

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
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int value : a) {
      valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
    }

    OptionalInt minUnique =
        valueToCount.keySet().stream()
            .filter(value -> valueToCount.get(value) == 1)
            .mapToInt(x -> x)
            .min();
    if (!minUnique.isPresent()) {
      return -1;
    }

    return IntStream.range(0, a.length)
            .filter(i -> a[i] == minUnique.getAsInt())
            .findAny()
            .getAsInt()
        + 1;
  }
}
