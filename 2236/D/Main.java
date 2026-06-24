import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a, int k) {
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int ai : a) {
      valueToCount.put(ai, valueToCount.getOrDefault(ai, 0) + 1);
    }

    Element[] elements =
        valueToCount.keySet().stream()
            .sorted(Comparator.reverseOrder())
            .map(value -> new Element(value, valueToCount.get(value)))
            .toArray(Element[]::new);

    int index = 0;
    while (true) {
      if (index == elements.length) {
        return false;
      }
      if (elements[index].count() % 2 == 0
          || (index != elements.length - 1
              && elements[index].value() - elements[index + 1].value() <= k)) {
        return true;
      }

      ++index;
    }
  }
}

record Element(int value, int count) {}
