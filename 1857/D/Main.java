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
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static String solve(int[] a, int[] b) {
    Map<Integer, List<Integer>> diffToIndices = new HashMap<>();
    for (int i = 0; i < a.length; ++i) {
      diffToIndices.putIfAbsent(a[i] - b[i], new ArrayList<>());
      diffToIndices.get(a[i] - b[i]).add(i);
    }

    int maxDiff = diffToIndices.keySet().stream().mapToInt(Integer::intValue).max().getAsInt();

    return String.format(
        "%d\n%s",
        diffToIndices.get(maxDiff).size(),
        diffToIndices.get(maxDiff).stream()
            .map(index -> index + 1)
            .map(String::valueOf)
            .collect(Collectors.joining(" ")));
  }
}
