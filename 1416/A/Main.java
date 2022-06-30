import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
    Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
    for (int i = 0; i < a.length; ++i) {
      valueToIndices.putIfAbsent(a[i], new ArrayList<>());
      valueToIndices.get(a[i]).add(i);
    }

    int[] result = new int[a.length];
    Arrays.fill(result, Integer.MAX_VALUE);

    for (int value : valueToIndices.keySet()) {
      List<Integer> indices = valueToIndices.get(value);
      int k =
          IntStream.rangeClosed(0, indices.size())
              .map(
                  i ->
                      ((i == indices.size()) ? a.length : indices.get(i))
                          - ((i == 0) ? -1 : indices.get(i - 1)))
              .max()
              .getAsInt();

      result[k - 1] = Math.min(result[k - 1], value);
    }

    int min = Integer.MAX_VALUE;
    for (int i = 0; i < result.length; ++i) {
      min = Math.min(min, result[i]);
      result[i] = min;
    }

    for (int i = 0; i < result.length; ++i) {
      if (result[i] == Integer.MAX_VALUE) {
        result[i] = -1;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}