import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
    Map<Integer, List<Integer>> colorToIndices = new HashMap<>();
    for (int i = 0; i < a.length; ++i) {
      if (!colorToIndices.containsKey(a[i])) {
        colorToIndices.put(a[i], new ArrayList<>());
      }
      colorToIndices.get(a[i]).add(i);
    }

    int[] sortedColors =
        colorToIndices.keySet().stream()
            .sorted(Comparator.comparing(color -> colorToIndices.get(color).size()).reversed())
            .mapToInt(x -> x)
            .toArray();
    List<Integer> sortedIndices = new ArrayList<>();
    for (int color : sortedColors) {
      for (int index : colorToIndices.get(color)) {
        sortedIndices.add(index);
      }
    }

    int prevColor = -1;
    int[] result = new int[a.length];
    int index = 0;
    while (true) {
      while (index != sortedIndices.size() && a[sortedIndices.get(index)] == prevColor) {
        ++index;
      }

      if (index + k > sortedIndices.size()) {
        break;
      }

      prevColor = a[sortedIndices.get(index)];
      for (int i = 0; i < k; ++i) {
        result[sortedIndices.get(index + i)] = i + 1;
      }
      index += k;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
