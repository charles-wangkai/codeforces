import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

  static int solve(int[] a) {
    Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
    for (int i = 0; i < a.length; ++i) {
      if (!valueToIndices.containsKey(a[i])) {
        valueToIndices.put(a[i], new ArrayList<>());
      }

      valueToIndices.get(a[i]).add(i);
    }

    return valueToIndices.values().stream()
            .filter(indices -> indices.size() == 1)
            .findAny()
            .get()
            .get(0)
        + 1;
  }
}
