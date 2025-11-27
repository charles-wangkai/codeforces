import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
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

  static String solve(int[] a) {
    long maxSum = Long.MIN_VALUE;
    int bestBeginIndex = -1;
    int bestEndIndex = -1;
    for (int i = 0; i < a.length; ++i) {
      for (int j = i + 1; j < a.length; ++j) {
        if (a[i] == a[j]) {
          long sum =
              a[i] * 2
                  + IntStream.rangeClosed(i + 1, j - 1)
                      .map(k -> Math.max(0, a[k]))
                      .asLongStream()
                      .sum();
          if (sum > maxSum) {
            maxSum = sum;
            bestBeginIndex = i;
            bestEndIndex = j;
          }
        }
      }
    }

    int bestBeginIndex_ = bestBeginIndex;
    int bestEndIndex_ = bestEndIndex;
    int[] cutIndices =
        IntStream.range(0, a.length)
            .filter(
                i ->
                    i < bestBeginIndex_
                        || i > bestEndIndex_
                        || (i != bestBeginIndex_ && i != bestEndIndex_ && a[i] < 0))
            .toArray();

    return "%d %d\n%s"
        .formatted(
            maxSum,
            cutIndices.length,
            Arrays.stream(cutIndices)
                .map(cutIndex -> cutIndex + 1)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
  }
}