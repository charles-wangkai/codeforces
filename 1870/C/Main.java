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
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static String solve(int[] a, int k) {
    Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
    for (int i = 0; i < a.length; ++i) {
      valueToIndices.putIfAbsent(a[i], new ArrayList<>());
      valueToIndices.get(a[i]).add(i);
    }

    int[] result = new int[k];
    boolean[] visited = new boolean[a.length];
    int leftIndex = 0;
    int rightIndex = visited.length - 1;
    for (int i = 0; i < result.length; ++i) {
      if (valueToIndices.containsKey(i + 1)) {
        while (visited[leftIndex]) {
          ++leftIndex;
        }
        while (visited[rightIndex]) {
          --rightIndex;
        }

        result[i] = 2 * (rightIndex - leftIndex + 1);

        for (int index : valueToIndices.get(i + 1)) {
          visited[index] = true;
        }
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}