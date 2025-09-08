import java.util.ArrayList;
import java.util.Arrays;
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
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(b));
    }

    sc.close();
  }

  static String solve(int[] b) {
    Map<Integer, List<Integer>> countToIndices = new HashMap<>();
    for (int i = 0; i < b.length; ++i) {
      countToIndices.putIfAbsent(b[i], new ArrayList<>());
      countToIndices.get(b[i]).add(i);
    }

    int[] result = new int[b.length];
    int value = 1;
    for (int count : countToIndices.keySet()) {
      List<Integer> indices = countToIndices.get(count);
      if (indices.size() % count != 0) {
        return "-1";
      }

      for (int i = 0; i < indices.size() / count; ++i) {
        for (int j = i * count; j < (i + 1) * count; ++j) {
          result[indices.get(j)] = value;
        }

        ++value;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}