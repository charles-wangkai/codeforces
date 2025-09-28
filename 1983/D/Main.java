import java.util.Arrays;
import java.util.Scanner;

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
      int[] b = new int[n];
      for (int i = 0; i < b.length; ++i) {
        b[i] = sc.nextInt();
      }

      System.out.println(solve(a, b) ? "YES" : "NO");
    }

    sc.close();
  }

  static boolean solve(int[] a, int[] b) {
    if (computeInversionNum(a, 0, a.length - 1) % 2
        != computeInversionNum(b, 0, b.length - 1) % 2) {
      return false;
    }

    return Arrays.equals(a, b);
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