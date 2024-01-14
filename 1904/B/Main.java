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
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static String solve(int[] a) {
    int[] sortedIndices =
        IntStream.range(0, a.length)
            .boxed()
            .sorted(Comparator.comparing(i -> a[i]))
            .mapToInt(Integer::intValue)
            .toArray();

    int[] result = new int[a.length];
    long sum = 0;
    int count = 0;
    for (int i = 0; i < sortedIndices.length; ++i) {
      if (i == count) {
        sum += a[sortedIndices[i]];
        ++count;

        while (count != sortedIndices.length && sum >= a[sortedIndices[count]]) {
          sum += a[sortedIndices[count]];
          ++count;
        }
      }

      result[sortedIndices[i]] = count - 1;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}