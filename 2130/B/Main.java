import static java.util.Map.entry;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  static final Map<Integer, Integer> VALUE_TO_ORDER =
      Map.ofEntries(entry(0, 0), entry(2, 1), entry(1, 2));

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int s = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, s));
    }

    sc.close();
  }

  static String solve(int[] a, int s) {
    int sum = Arrays.stream(a).sum();

    return (sum > s || sum == s - 1)
        ? Arrays.stream(a)
            .boxed()
            .sorted(Comparator.comparing(VALUE_TO_ORDER::get))
            .map(String::valueOf)
            .collect(Collectors.joining(" "))
        : "-1";
  }
}