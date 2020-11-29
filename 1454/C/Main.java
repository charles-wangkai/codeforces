import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
    for (int i = 0; i < a.length; ++i) {
      if (!valueToIndices.containsKey(a[i])) {
        valueToIndices.put(a[i], new ArrayList<>());
      }

      valueToIndices.get(a[i]).add(i);
    }

    return valueToIndices.values().stream()
        .mapToInt(
            indices ->
                ((indices.get(0) == 0) ? 0 : 1)
                    + IntStream.range(0, indices.size() - 1)
                        .map(i -> (indices.get(i) + 1 == indices.get(i + 1)) ? 0 : 1)
                        .sum()
                    + ((indices.get(indices.size() - 1) == a.length - 1) ? 0 : 1))
        .min()
        .getAsInt();
  }
}
