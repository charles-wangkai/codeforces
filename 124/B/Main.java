import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    sc.nextInt();
    String[] values = new String[n];
    for (int i = 0; i < values.length; ++i) {
      values[i] = sc.next();
    }

    System.out.println(solve(values));

    sc.close();
  }

  static int solve(String[] values) {
    int k = values[0].length();

    return search(values, IntStream.range(0, k).toArray(), 0);
  }

  static int search(String[] values, int[] indices, int depth) {
    if (depth == indices.length) {
      int[] sorted =
          Arrays.stream(values)
              .mapToInt(
                  value ->
                      Integer.parseInt(
                          Arrays.stream(indices)
                              .mapToObj(value::charAt)
                              .map(String::valueOf)
                              .collect(Collectors.joining())))
              .sorted()
              .toArray();

      return sorted[sorted.length - 1] - sorted[0];
    }

    int result = Integer.MAX_VALUE;
    for (int i = depth; i < indices.length; ++i) {
      swap(indices, i, depth);
      result = Math.min(result, search(values, indices, depth + 1));
      swap(indices, i, depth);
    }

    return result;
  }

  static void swap(int[] a, int index1, int index2) {
    int temp = a[index1];
    a[index1] = a[index2];
    a[index2] = temp;
  }
}