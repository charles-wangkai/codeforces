import java.util.Arrays;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
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
    SortedMap<Integer, Integer> valueToCount = new TreeMap<>();
    for (int value : a) {
      valueToCount.put(value, valueToCount.getOrDefault(value, 0) + 1);
    }

    int[] b = new int[a.length];
    int index = 0;
    for (int value : valueToCount.keySet()) {
      b[index] = value;
      valueToCount.put(value, valueToCount.get(value) - 1);
      ++index;
    }
    for (int value : valueToCount.keySet()) {
      for (int i = 0; i < valueToCount.get(value); ++i) {
        b[index] = value;
        ++index;
      }
    }

    return Arrays.stream(b).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
