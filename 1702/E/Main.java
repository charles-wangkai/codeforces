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
      int[] b = new int[n];
      for (int i = 0; i < n; ++i) {
        a[i] = sc.nextInt();
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a, int[] b) {
    if (IntStream.range(0, a.length).anyMatch(i -> a[i] == b[i])) {
      return false;
    }

    Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
    for (int i = 0; i < a.length; ++i) {
      valueToIndices.putIfAbsent(a[i], new ArrayList<>());
      valueToIndices.get(a[i]).add(i);

      valueToIndices.putIfAbsent(b[i], new ArrayList<>());
      valueToIndices.get(b[i]).add(i);
    }

    int[] colors = new int[a.length];
    for (int i = 0; i < colors.length; ++i) {
      if (colors[i] == 0 && !search(a, b, valueToIndices, colors, i, 1)) {
        return false;
      }
    }

    return true;
  }

  static boolean search(
      int[] a,
      int[] b,
      Map<Integer, List<Integer>> valueToIndices,
      int[] colors,
      int node,
      int color) {
    if (colors[node] != 0) {
      return colors[node] == color;
    }

    colors[node] = color;

    for (int value : new int[] {a[node], b[node]}) {
      for (int index : valueToIndices.get(value)) {
        if (index != node && !search(a, b, valueToIndices, colors, index, -color)) {
          return false;
        }
      }
    }

    return true;
  }
}
