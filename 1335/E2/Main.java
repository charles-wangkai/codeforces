import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  static final int LIMIT = 200;

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

  static int solve(int[] a) {
    int[][] prefixCounts = new int[a.length + 1][LIMIT + 1];
    for (int length = 1; length < prefixCounts.length; ++length) {
      for (int value = 1; value <= LIMIT; ++value) {
        prefixCounts[length][value] =
            prefixCounts[length - 1][value] + ((a[length - 1] == value) ? 1 : 0);
      }
    }

    int result = -1;
    for (int sideValue = 1; sideValue <= LIMIT; ++sideValue) {
      int sideValue_ = sideValue;
      int[] indices = IntStream.range(0, a.length).filter(i -> a[i] == sideValue_).toArray();

      result = Math.max(result, computeMaxLength(prefixCounts, indices));
    }

    return result;
  }

  static int computeMaxLength(int[][] prefixCounts, int[] indices) {
    int result = indices.length;
    for (int i = 0, j = indices.length - 1; i < j; ++i, --j) {
      for (int middleValue = 1; middleValue <= LIMIT; ++middleValue) {
        result =
            Math.max(
                result,
                (i + 1) * 2
                    + (prefixCounts[indices[j]][middleValue]
                        - prefixCounts[indices[i] + 1][middleValue]));
      }
    }

    return result;
  }
}
