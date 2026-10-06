import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static long solve(int[] a, int k) {
    int n = a.length;

    int needed = n - k + 1;

    int leftIndex = k - 1;
    int rightIndex = n - k;
    if (leftIndex > rightIndex) {
      return IntStream.range(0, needed)
          .map(i -> Math.max(a[rightIndex - i], a[leftIndex + i]))
          .asLongStream()
          .sum();
    }

    int middleLength = rightIndex - leftIndex + 1;

    return (needed <= middleLength)
        ? computeMaxScore(subarray(a, leftIndex, rightIndex), needed)
        : (IntStream.rangeClosed(leftIndex, rightIndex).map(i -> a[i]).asLongStream().sum()
            + IntStream.range(0, needed - middleLength)
                .map(i -> Math.max(a[leftIndex - 1 - i], a[rightIndex + 1 + i]))
                .asLongStream()
                .sum());
  }

  static int[] subarray(int[] values, int beginIndex, int endIndex) {
    return IntStream.rangeClosed(beginIndex, endIndex).map(i -> values[i]).toArray();
  }

  static long computeMaxScore(int[] values, int chosenNum) {
    long leftSum = 0;
    long rightSum =
        IntStream.range(0, chosenNum).map(i -> values[values.length - 1 - i]).asLongStream().sum();
    long result = rightSum;
    for (int i = 0; i < chosenNum; ++i) {
      leftSum += values[i];
      rightSum -= values[values.length - chosenNum + i];

      result = Math.max(result, leftSum + rightSum);
    }

    return result;
  }
}