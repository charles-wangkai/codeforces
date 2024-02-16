import java.util.Comparator;
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

      System.out.println(solve(a, b));
    }

    sc.close();
  }

  static long solve(int[] a, int[] b) {
    int n = a.length;

    return computeInversionNum(
        IntStream.range(0, n)
            .boxed()
            .sorted(Comparator.comparing(i -> a[i]))
            .mapToInt(i -> b[i])
            .toArray(),
        0,
        n - 1);
  }

  static long computeInversionNum(int[] values, int beginIndex, int endIndex) {
    if (beginIndex == endIndex) {
      return 0;
    }

    int middleIndex = (beginIndex + endIndex) / 2;
    long result =
        computeInversionNum(values, beginIndex, middleIndex)
            + computeInversionNum(values, middleIndex + 1, endIndex);

    int[] sorted = new int[endIndex - beginIndex + 1];
    int leftIndex = beginIndex;
    int rightIndex = middleIndex + 1;
    for (int i = 0; i < sorted.length; ++i) {
      if (rightIndex == endIndex + 1
          || (leftIndex != middleIndex + 1 && values[leftIndex] < values[rightIndex])) {
        sorted[i] = values[leftIndex];
        ++leftIndex;
      } else {
        sorted[i] = values[rightIndex];
        ++rightIndex;

        result += middleIndex + 1 - leftIndex;
      }
    }

    for (int i = 0; i < sorted.length; ++i) {
      values[beginIndex + i] = sorted[i];
    }

    return result;
  }
}