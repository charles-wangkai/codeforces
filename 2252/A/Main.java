import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int ai : a) {
      updateMap(valueToCount, ai, 1);
    }

    List<Integer> damages = new ArrayList<>();
    while (!valueToCount.isEmpty()) {
      int last = damages.isEmpty() ? -1 : damages.getLast();

      Optional<Integer> value =
          valueToCount.keySet().stream()
              .filter(x -> x != last)
              .max(Comparator.comparing(valueToCount::get));
      if (value.isPresent()) {
        damages.add(value.get());
        updateMap(valueToCount, value.get(), -1);
      } else {
        damages.add(last);

        break;
      }
    }

    return damages.stream().mapToInt(Integer::intValue).sum();
  }

  static void updateMap(Map<Integer, Integer> valueToCount, int value, int delta) {
    valueToCount.put(value, valueToCount.getOrDefault(value, 0) + delta);
    valueToCount.remove(value, 0);
  }
}