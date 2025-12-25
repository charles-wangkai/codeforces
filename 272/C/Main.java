import java.util.Arrays;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }
    int m = sc.nextInt();
    int[] w = new int[m];
    int[] h = new int[m];
    for (int i = 0; i < m; ++i) {
      w[i] = sc.nextInt();
      h[i] = sc.nextInt();
    }

    System.out.println(solve(a, w, h));

    sc.close();
  }

  static String solve(int[] a, int[] w, int[] h) {
    NavigableMap<Integer, Long> widthToHeight = new TreeMap<>();
    for (int i = 0; i < a.length; ++i) {
      if (i == 0 || a[i] != a[i - 1]) {
        widthToHeight.put(i + 1, (long) a[i]);
      }
    }

    long[] result = new long[w.length];
    for (int i = 0; i < result.length; ++i) {
      int floorWidth = widthToHeight.floorKey(w[i]);
      result[i] = widthToHeight.get(floorWidth);

      while (!widthToHeight.isEmpty() && widthToHeight.firstKey() <= w[i]) {
        widthToHeight.remove(widthToHeight.firstKey());
      }

      long nextHeight = result[i] + h[i];

      widthToHeight.put(1, nextHeight);

      while (true) {
        Integer higherWidth = widthToHeight.higherKey(w[i]);
        if (higherWidth == null || widthToHeight.get(higherWidth) > nextHeight) {
          break;
        }

        widthToHeight.remove(higherWidth);
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining("\n"));
  }
}