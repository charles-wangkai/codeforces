import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, k));

    sc.close();
  }

  static String solve(int[] a, int k) {
    int[] prefixCounts = new int[a.length + 1];
    for (int i = 1; i < prefixCounts.length; ++i) {
      prefixCounts[i] = prefixCounts[i - 1] + (1 - a[i - 1]);
    }

    int maxF = 0;
    int beginIndexForMaxF = 0;
    int lower = 1;
    int upper = a.length;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      int beginIndex = findBeginIndex(k, prefixCounts, middle);
      if (beginIndex == -1) {
        upper = middle - 1;
      } else {
        maxF = middle;
        beginIndexForMaxF = beginIndex;
        lower = middle + 1;
      }
    }

    for (int i = beginIndexForMaxF; i < beginIndexForMaxF + maxF; ++i) {
      a[i] = 1;
    }

    return "%d\n%s"
        .formatted(
            maxF, Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
  }

  static int findBeginIndex(int k, int[] prefixCounts, int length) {
    int n = prefixCounts.length - 1;

    for (int beginIndex = 0; beginIndex + length <= n; ++beginIndex) {
      if (prefixCounts[beginIndex + length] - prefixCounts[beginIndex] <= k) {
        return beginIndex;
      }
    }

    return -1;
  }
}