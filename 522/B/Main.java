import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] w = new int[n];
    int[] h = new int[n];
    for (int i = 0; i < n; ++i) {
      w[i] = sc.nextInt();
      h[i] = sc.nextInt();
    }

    System.out.println(solve(w, h));

    sc.close();
  }

  static String solve(int[] w, int[] h) {
    int n = w.length;

    int[] leftMaxHeights = new int[n];
    for (int i = 0; i < leftMaxHeights.length; ++i) {
      leftMaxHeights[i] = Math.max((i == 0) ? -1 : leftMaxHeights[i - 1], h[i]);
    }

    int[] rightMaxHeights = new int[n];
    for (int i = rightMaxHeights.length - 1; i >= 0; --i) {
      rightMaxHeights[i] =
          Math.max((i == rightMaxHeights.length - 1) ? -1 : rightMaxHeights[i + 1], h[i]);
    }

    int widthSum = Arrays.stream(w).sum();

    return IntStream.range(0, n)
        .map(
            i ->
                (widthSum - w[i])
                    * Math.max(
                        (i == 0) ? -1 : leftMaxHeights[i - 1],
                        (i == n - 1) ? -1 : rightMaxHeights[i + 1]))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }
}