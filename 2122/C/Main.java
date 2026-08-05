import java.util.ArrayList;
import java.util.Comparator;
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
      int[] x = new int[n];
      int[] y = new int[n];
      for (int i = 0; i < n; ++i) {
        x[i] = sc.nextInt();
        y[i] = sc.nextInt();
      }

      System.out.println(solve(x, y));
    }

    sc.close();
  }

  static String solve(int[] x, int[] y) {
    int n = x.length;

    int[] xSortedIndices = buildSortedIndices(x);

    int[] ySortedIndices = buildSortedIndices(y);
    Map<Integer, Integer> indexToYPos =
        IntStream.range(0, ySortedIndices.length)
            .boxed()
            .collect(Collectors.toMap(i -> ySortedIndices[i], i -> i));

    @SuppressWarnings("unchecked")
    List<Integer>[][] indexGroups = new List[2][2];
    for (int i = 0; i < 2; ++i) {
      for (int j = 0; j < 2; ++j) {
        indexGroups[i][j] = new ArrayList<>();
      }
    }

    for (int i = 0; i < xSortedIndices.length; ++i) {
      int index = xSortedIndices[i];

      indexGroups[(i < n / 2) ? 0 : 1][(indexToYPos.get(index) < n / 2) ? 0 : 1].add(index);
    }

    List<String> pairs = new ArrayList<>();
    for (int i = 0; i < indexGroups[0][0].size(); ++i) {
      pairs.add("%d %d".formatted(indexGroups[0][0].get(i) + 1, indexGroups[1][1].get(i) + 1));
    }
    for (int i = 0; i < indexGroups[0][1].size(); ++i) {
      pairs.add("%d %d".formatted(indexGroups[0][1].get(i) + 1, indexGroups[1][0].get(i) + 1));
    }

    return String.join("\n", pairs);
  }

  static int[] buildSortedIndices(int[] values) {
    return IntStream.range(0, values.length)
        .boxed()
        .sorted(Comparator.comparing(i -> values[i]))
        .mapToInt(Integer::intValue)
        .toArray();
  }
}