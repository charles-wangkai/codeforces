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
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    int n = a.length;

    Map<Integer, Integer> valueToCount = new HashMap<>();
    for (int ai : a) {
      valueToCount.put(ai, valueToCount.getOrDefault(ai, 0) + 1);
    }

    int mex = 0;
    while (valueToCount.containsKey(mex)) {
      ++mex;
    }

    int[] deltas = new int[n + 2];
    for (int i = mex; i >= 0; --i) {
      ++deltas[valueToCount.getOrDefault(i, 0)];
      --deltas[n - i + 1];
    }

    int[] result = new int[n + 1];
    int wayNum = 0;
    for (int i = 0; i < result.length; ++i) {
      wayNum += deltas[i];
      result[i] = wayNum;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}