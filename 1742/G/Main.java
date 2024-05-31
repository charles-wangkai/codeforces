import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

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
    List<Integer> result = new ArrayList<>();

    int or = 0;
    Map<Integer, List<Integer>> restToValues = new HashMap<>();
    for (int ai : a) {
      restToValues.putIfAbsent(ai, new ArrayList<>());
      restToValues.get(ai).add(ai);
    }

    while (restToValues.size() >= 2) {
      int maxRest = restToValues.keySet().stream().mapToInt(Integer::intValue).max().getAsInt();

      int value = restToValues.get(maxRest).get(0);
      result.add(value);
      or |= value;

      Map<Integer, List<Integer>> nextRestToValues = new HashMap<>();
      for (int rest : restToValues.keySet()) {
        List<Integer> values = restToValues.get(rest);
        for (int i = (rest == maxRest) ? 1 : 0; i < values.size(); ++i) {
          int nextRest = (Integer.MAX_VALUE ^ or) & values.get(i);
          nextRestToValues.putIfAbsent(nextRest, new ArrayList<>());
          nextRestToValues.get(nextRest).add(values.get(i));
        }
      }

      restToValues = nextRestToValues;
    }

    if (!restToValues.isEmpty()) {
      result.addAll(restToValues.values().iterator().next());
    }

    return result.stream().map(String::valueOf).collect(Collectors.joining(" "));
  }
}