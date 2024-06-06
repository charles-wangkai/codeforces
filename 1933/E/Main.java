import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
      int q = sc.nextInt();
      int[] l = new int[q];
      int[] u = new int[q];
      for (int i = 0; i < q; ++i) {
        l[i] = sc.nextInt();
        u[i] = sc.nextInt();
      }

      System.out.println(solve(a, l, u));
    }

    sc.close();
  }

  static String solve(int[] a, int[] l, int[] u) {
    int[] prefixSums = new int[a.length + 1];
    for (int i = 1; i < prefixSums.length; ++i) {
      prefixSums[i] = prefixSums[i - 1] + a[i - 1];
    }

    return IntStream.range(0, l.length)
        .map(i -> findR(prefixSums, l[i], u[i]))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }

  static int findR(int[] prefixSums, int left, int initial) {
    int result = -1;
    long maxSum = Long.MIN_VALUE;
    int lower = left;
    int upper = prefixSums.length - 1;
    while (lower <= upper) {
      int middle = (lower + upper) / 2;

      int length = prefixSums[middle] - prefixSums[left - 1];
      long sum = (long) length * initial - length * (length - 1L) / 2;
      if (sum > maxSum || (sum == maxSum && middle < result)) {
        maxSum = sum;
        result = middle;
      }

      if (initial - (length - 1) <= 0) {
        upper = middle - 1;
      } else {
        lower = middle + 1;
      }
    }

    return result;
  }
}