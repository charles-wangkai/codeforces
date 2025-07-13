import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a));

    sc.close();
  }

  static int solve(int[] a) {
    return IntStream.rangeClosed(1, Arrays.stream(a).max().getAsInt())
        .map(removed -> computeScore(a, removed))
        .max()
        .orElse(0);
  }

  static int computeScore(int[] a, int removed) {
    int[] leftMaxSums = new int[a.length];
    int leftSum = 0;
    int minLeftSum = 0;
    for (int i = 0; i < leftMaxSums.length; ++i) {
      leftMaxSums[i] = Math.max(0, leftSum - minLeftSum);

      if (a[i] >= removed) {
        leftSum = 0;
        minLeftSum = 0;
      } else {
        leftSum += a[i];
        minLeftSum = Math.min(minLeftSum, leftSum);
      }
    }

    int[] rightMaxSums = new int[a.length];
    int rightSum = 0;
    int minRightSum = 0;
    for (int i = rightMaxSums.length - 1; i >= 0; --i) {
      rightMaxSums[i] = Math.max(0, rightSum - minRightSum);

      if (a[i] > removed) {
        rightSum = 0;
        minRightSum = 0;
      } else {
        rightSum += a[i];
        minRightSum = Math.min(minRightSum, rightSum);
      }
    }

    return IntStream.range(0, a.length)
        .filter(i -> a[i] == removed)
        .map(i -> leftMaxSums[i] + rightMaxSums[i])
        .max()
        .orElse(0);
  }
}