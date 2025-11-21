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
    int[] result = new int[a.length];
    for (int i = 0; i < result.length; ++i) {
      int minIndex = Math.max(0, i - k);
      int maxIndex = Math.min(a.length - 1, i + k);

      if (a[i] == 0) {
        result[i] = maxIndex - minIndex + 1;
      } else {
        int prevMinIndex = Math.max(0, a[i] - 1 - k);
        int prevMaxIndex = Math.min(a.length - 1, a[i] - 1 + k);

        int commonMinIndex = Math.max(minIndex, prevMinIndex);
        int commonMaxIndex = Math.min(maxIndex, prevMaxIndex);

        result[i] =
            result[a[i] - 1]
                + (maxIndex - minIndex + 1 - Math.max(0, commonMaxIndex - commonMinIndex + 1));
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}