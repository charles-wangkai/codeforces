import java.util.ArrayList;
import java.util.Comparator;
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
      int k = sc.nextInt();
      int[] c = new int[n];
      for (int i = 0; i < c.length; ++i) {
        c[i] = sc.nextInt();
      }

      System.out.println(solve(c, k));
    }

    sc.close();
  }

  static int solve(int[] c, int k) {
    Map<Integer, List<Integer>> colorToIndices = new HashMap<>();
    for (int i = 0; i < c.length; ++i) {
      colorToIndices.putIfAbsent(c[i], new ArrayList<>());
      colorToIndices.get(c[i]).add(i);
    }

    return colorToIndices.values().stream()
        .mapToInt(indices -> computeMaxStep(c.length, indices))
        .min()
        .getAsInt();
  }

  static int computeMaxStep(int n, List<Integer> indices) {
    int[] sortedSteps =
        IntStream.rangeClosed(0, indices.size())
            .map(
                i ->
                    ((i == indices.size()) ? n : indices.get(i))
                        - ((i == 0) ? -1 : indices.get(i - 1))
                        - 1)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

    return Math.max(sortedSteps[0] / 2, sortedSteps[1]);
  }
}
