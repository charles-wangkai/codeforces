import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[][] b = new int[n][m];
      for (int i = 0; i < n; ++i) {
        for (int j = 0; j < m; ++j) {
          b[i][j] = sc.nextInt();
        }
      }

      System.out.println(solve(b));
    }

    sc.close();
  }

  static String solve(int[][] b) {
    int n = b.length;
    int m = b[0].length;

    int[] mins = new int[m];
    Arrays.fill(mins, Integer.MAX_VALUE);

    int[][] result = new int[n][m];
    for (int i = 0; i < n; ++i) {
      int[] sortedIndices =
          IntStream.range(0, mins.length)
              .boxed()
              .sorted(Comparator.comparing(j -> mins[j]))
              .mapToInt(x -> x)
              .toArray();

      int[] sortedRow =
          Arrays.stream(b[i]).boxed().sorted(Comparator.reverseOrder()).mapToInt(x -> x).toArray();

      for (int j = 0; j < m; ++j) {
        result[i][sortedIndices[j]] = sortedRow[j];
      }

      for (int j = 0; j < mins.length; ++j) {
        mins[j] = Math.min(mins[j], result[i][j]);
      }
    }

    return Arrays.stream(result)
        .map(row -> Arrays.stream(row).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
        .collect(Collectors.joining("\n"));
  }
}
