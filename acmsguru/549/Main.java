import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] m = new int[n];
    int[] c = new int[n];
    for (int i = 0; i < n; ++i) {
      m[i] = sc.nextInt();
      c[i] = sc.nextInt();
    }

    System.out.println(solve(m, c, k));

    sc.close();
  }

  static String solve(int[] m, int[] c, int k) {
    Map<Integer, List<Integer>> massToCosts = new HashMap<>();
    for (int i = 0; i < m.length; ++i) {
      if (!massToCosts.containsKey(m[i])) {
        massToCosts.put(m[i], new ArrayList<>());
      }
      massToCosts.get(m[i]).add(c[i]);
    }

    if (massToCosts.size() < k) {
      return "0 0";
    }

    int setNum =
        massToCosts.values().stream()
            .mapToInt(List::size)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .skip(k - 1)
            .findFirst()
            .get();

    int totalCost =
        massToCosts.values().stream()
            .filter(costs -> costs.size() >= setNum)
            .mapToInt(
                costs ->
                    costs.stream()
                        .sorted(Comparator.reverseOrder())
                        .limit(setNum)
                        .mapToInt(x -> x)
                        .sum())
            .boxed()
            .sorted(Comparator.reverseOrder())
            .limit(k)
            .mapToInt(x -> x)
            .sum();

    return String.format("%d %d", setNum, totalCost);
  }
}
