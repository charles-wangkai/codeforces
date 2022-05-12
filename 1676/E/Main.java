import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int q = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] x = new int[q];
      for (int i = 0; i < x.length; ++i) {
        x[i] = sc.nextInt();
      }

      System.out.println(solve(a, x));
    }

    sc.close();
  }

  static String solve(int[] a, int[] x) {
    int[] sorted =
        Arrays.stream(a).boxed().sorted(Comparator.reverseOrder()).mapToInt(ai -> ai).toArray();

    int[] prefixSums = new int[sorted.length];
    for (int i = 0; i < prefixSums.length; ++i) {
      prefixSums[i] = ((i == 0) ? 0 : prefixSums[i - 1]) + sorted[i];
    }

    return Arrays.stream(x)
        .map(xi -> find(prefixSums, xi))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("\n"));
  }

  static int find(int[] prefixSums, int target) {
    int result = -1;
    int lower = 0;
    int upper = prefixSums.length - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;
      if (prefixSums[middle] >= target) {
        result = middle + 1;
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }
}