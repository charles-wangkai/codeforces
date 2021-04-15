import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int q = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    int[] t = new int[q];
    for (int i = 0; i < t.length; ++i) {
      t[i] = sc.nextInt();
    }

    System.out.println(solve(a, t));

    sc.close();
  }

  static String solve(int[] a, int[] t) {
    Map<Integer, Integer> colorToMinIndex = new HashMap<>();
    for (int i = 0; i < a.length; ++i) {
      if (!colorToMinIndex.containsKey(a[i])) {
        colorToMinIndex.put(a[i], i);
      }
    }

    int[] result = new int[t.length];
    for (int i = 0; i < result.length; ++i) {
      int minIndex = colorToMinIndex.get(t[i]);
      result[i] = minIndex + 1;

      for (int color : colorToMinIndex.keySet()) {
        if (colorToMinIndex.get(color) < minIndex) {
          colorToMinIndex.put(color, colorToMinIndex.get(color) + 1);
        }
      }
      colorToMinIndex.put(t[i], 0);
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
