import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int m = sc.nextInt();
    int[] b = new int[m];
    for (int i = 0; i < b.length; ++i) {
      b[i] = sc.nextInt();
    }

    System.out.println(solve(b));

    sc.close();
  }

  static String solve(int[] b) {
    SortedMap<Integer, Integer> valueToCount = new TreeMap<>(Comparator.reverseOrder());
    for (int bi : b) {
      valueToCount.put(bi, valueToCount.getOrDefault(bi, 0) + 1);
    }

    Deque<Integer> cards = new ArrayDeque<>();
    for (int value : valueToCount.keySet()) {
      if (!cards.isEmpty() && valueToCount.get(value) != 1) {
        cards.offerFirst(value);
      }
      cards.offerLast(value);
    }

    return String.format(
        "%d\n%s",
        cards.size(), cards.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }
}