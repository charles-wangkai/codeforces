import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] x = new int[n];
      for (int i = 0; i < x.length; ++i) {
        x[i] = sc.nextInt();
      }

      System.out.println(solve(x));
    }

    sc.close();
  }

  static String solve(int[] x) {
    int[] sortedIndices =
        IntStream.range(0, x.length)
            .boxed()
            .sorted(Comparator.comparing(i -> x[i]))
            .mapToInt(Integer::intValue)
            .toArray();

    long[] result = new long[x.length];
    long total = Arrays.stream(x).asLongStream().sum();
    long leftSum = 0;
    for (int i = 0; i < sortedIndices.length; ++i) {
      leftSum += x[sortedIndices[i]];
      result[sortedIndices[i]] =
          (x[sortedIndices[i]] * (i + 1L) - leftSum)
              + (total - leftSum - x[sortedIndices[i]] * (x.length - i - 1L))
              + x.length;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}
