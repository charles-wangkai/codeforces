import java.util.Comparator;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static String solve(int n) {
    SortedMap<Integer, SortedSet<Integer>> trailingOneNumToValues =
        new TreeMap<>(Comparator.reverseOrder());
    for (int i = 0; i < 1 << n; ++i) {
      int rest = i;
      int trailingOneNum = 0;
      while (rest % 2 == 1) {
        ++trailingOneNum;
        rest /= 2;
      }

      trailingOneNumToValues.putIfAbsent(trailingOneNum, new TreeSet<>());
      trailingOneNumToValues.get(trailingOneNum).add(i);
    }

    return trailingOneNumToValues.values().stream()
        .flatMap(SortedSet::stream)
        .map(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}