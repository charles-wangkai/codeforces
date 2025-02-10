import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int[][] a = new int[n][m];
      for (int i = 0; i < a.length; ++i) {
        for (int j = 0; j < a[i].length; ++j) {
          a[i][j] = sc.nextInt();
        }
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static long solve(int[][] a) {
    long[] rowSums =
        Arrays.stream(a).mapToLong(line -> Arrays.stream(line).asLongStream().sum()).toArray();

    int[] sortedIndices =
        IntStream.range(0, rowSums.length)
            .boxed()
            .sorted(Comparator.<Integer, Long>comparing(i -> rowSums[i]).reversed())
            .mapToInt(Integer::intValue)
            .toArray();

    int[] values = Arrays.stream(sortedIndices).flatMap(index -> Arrays.stream(a[index])).toArray();

    return IntStream.range(0, values.length)
        .mapToLong(i -> (long) values[i] * (values.length - i))
        .sum();
  }
}