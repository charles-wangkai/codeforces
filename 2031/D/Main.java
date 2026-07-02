import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    int[] leftIndices = buildLeftIndices(a);

    int[] result = new int[n];
    int beginIndex = Integer.MAX_VALUE;
    int endIndex = n - 1;
    for (int i = n - 1; i >= 0; --i) {
      beginIndex = Math.min(beginIndex, leftIndices[i]);

      if (i == beginIndex) {
        int maxValue = IntStream.rangeClosed(beginIndex, endIndex).map(j -> a[j]).max().getAsInt();
        for (int j = beginIndex; j <= endIndex; ++j) {
          result[j] = maxValue;
        }

        endIndex = beginIndex - 1;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static int[] buildLeftIndices(int[] a) {
    int[] result = new int[a.length];
    List<Integer> indices = new ArrayList<>();
    for (int i = 0; i < result.length; ++i) {
      if (indices.isEmpty() || a[i] >= a[indices.getLast()]) {
        result[i] = i;

        if (indices.isEmpty() || a[i] > a[indices.getLast()]) {
          indices.add(i);
        }
      } else {
        result[i] = findIndex(a, indices, i);
      }
    }

    return result;
  }

  static int findIndex(int[] a, List<Integer> indices, int targetIndex) {
    int result = -1;
    int lower = 0;
    int upper = indices.size() - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (a[indices.get(middle)] > a[targetIndex]) {
        result = indices.get(middle);
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }
}