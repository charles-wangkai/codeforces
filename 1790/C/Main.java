import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[][] sequences = new int[n][n - 1];
      for (int i = 0; i < sequences.length; ++i) {
        for (int j = 0; j < sequences[i].length; ++j) {
          sequences[i][j] = sc.nextInt();
        }
      }

      System.out.println(solve(sequences));
    }

    sc.close();
  }

  static String solve(int[][] sequences) {
    int n = sequences.length;

    int[] result = new int[n];
    int[] indices = new int[n];
    for (int i = 0; i < result.length; ++i) {
      Map<Integer, Integer> valueToCount = new HashMap<>();
      for (int j = 0; j < n; ++j) {
        if (indices[j] != n - 1) {
          valueToCount.put(
              sequences[j][indices[j]], valueToCount.getOrDefault(sequences[j][indices[j]], 0) + 1);
        }
      }
      int maxCount = valueToCount.values().stream().mapToInt(Integer::intValue).max().getAsInt();
      int valueWithMaxCount =
          valueToCount.keySet().stream()
              .filter(value -> valueToCount.get(value) == maxCount)
              .findAny()
              .get();

      result[i] = valueWithMaxCount;
      for (int j = 0; j < indices.length; ++j) {
        if (indices[j] != n - 1 && sequences[j][indices[j]] == valueWithMaxCount) {
          ++indices[j];
        }
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
