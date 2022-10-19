import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int q = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] k = new int[q];
      for (int i = 0; i < k.length; ++i) {
        k[i] = sc.nextInt();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static String solve(int[] a, int[] k) {
    long[] heights = new long[a.length];
    for (int i = 0; i < heights.length; ++i) {
      heights[i] = ((i == 0) ? 0 : heights[i - 1]) + a[i];
    }

    int[] leftMaxs = new int[a.length];
    for (int i = 0; i < leftMaxs.length; ++i) {
      leftMaxs[i] = Math.max((i == 0) ? 0 : leftMaxs[i - 1], a[i]);
    }

    return IntStream.range(0, k.length)
        .mapToLong(i -> computeMaxHeight(heights, leftMaxs, k[i]))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }

  static long computeMaxHeight(long[] heights, int[] leftMaxs, int leg) {
    int index = -1;
    int lower = 0;
    int upper = heights.length - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (leg >= leftMaxs[middle]) {
        index = middle;
        lower = middle + 1;
      } else {
        upper = middle - 1;
      }
    }

    return (index == -1) ? 0 : heights[index];
  }
}
