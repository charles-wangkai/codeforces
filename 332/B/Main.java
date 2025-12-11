import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] x = new int[n];
    for (int i = 0; i < x.length; ++i) {
      x[i] = sc.nextInt();
    }

    System.out.println(solve(x, k));

    sc.close();
  }

  static String solve(int[] x, int k) {
    long[] prefixSums = new long[x.length + 1];
    for (int i = 1; i < prefixSums.length; ++i) {
      prefixSums[i] = prefixSums[i - 1] + x[i - 1];
    }

    long[] segmentSums =
        IntStream.rangeClosed(0, x.length - k)
            .mapToLong(i -> prefixSums[i + k] - prefixSums[i])
            .toArray();

    int[] bestAfterIndices = new int[segmentSums.length];
    for (int i = bestAfterIndices.length - 1; i >= 0; --i) {
      bestAfterIndices[i] =
          (i == bestAfterIndices.length - 1
                  || segmentSums[i] >= segmentSums[bestAfterIndices[i + 1]])
              ? i
              : bestAfterIndices[i + 1];
    }

    long maxSum = Long.MIN_VALUE;
    int bestLeftIndex = -1;
    int bestRightIndex = -1;
    for (int i = 0; i + k < segmentSums.length; ++i) {
      if (segmentSums[i] + segmentSums[bestAfterIndices[i + k]] > maxSum) {
        maxSum = segmentSums[i] + segmentSums[bestAfterIndices[i + k]];
        bestLeftIndex = i;
        bestRightIndex = bestAfterIndices[i + k];
      }
    }

    return "%d %d".formatted(bestLeftIndex + 1, bestRightIndex + 1);
  }
}