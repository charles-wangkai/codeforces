import java.util.Comparator;
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
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int ai : a) {
      valueToCount.put(ai, valueToCount.getOrDefault(ai, 0) + 1);
    }

    return valueToCount.keySet().stream()
        .flatMap(
            value ->
                IntStream.range(0, valueToCount.get(value)).mapToObj(i -> new Element(i, value)))
        .sorted(
            Comparator.comparing(Element::sequence)
                .thenComparing(Comparator.comparing(Element::value).reversed()))
        .mapToInt(Element::value)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}

record Element(int sequence, int value) {}
