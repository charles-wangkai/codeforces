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

    int[] duplicatedValues =
        valueToIndices.keySet().stream()
            .filter(value -> valueToIndices.get(value).size() >= 2)
            .mapToInt(Integer::intValue)
            .toArray();
    if (duplicatedValues.length < 2) {
      return "-1";
    }

    int[] b = new int[a.length];
    Arrays.fill(b, 1);
    b[valueToIndices.get(duplicatedValues[0]).get(0)] = 2;
    b[valueToIndices.get(duplicatedValues[1]).get(0)] = 3;

    return Arrays.stream(b).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
