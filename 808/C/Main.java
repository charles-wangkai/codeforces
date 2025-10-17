import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int w = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < a.length; ++i) {
      a[i] = sc.nextInt();
    }

    System.out.println(solve(a, w));

    sc.close();
  }

  static String solve(int[] a, int w) {
    int[] result = Arrays.stream(a).map(ai -> Math.ceilDiv(ai, 2)).toArray();

    int rest = w - Arrays.stream(result).sum();
    if (rest < 0) {
      return "-1";
    }

    int[] sortedIndices =
        IntStream.range(0, a.length)
            .boxed()
            .sorted(Comparator.<Integer, Integer>comparing(i -> a[i]).reversed())
            .mapToInt(Integer::intValue)
            .toArray();
    for (int index : sortedIndices) {
      int delta = Math.min(rest, a[index] - result[index]);
      result[index] += delta;
      rest -= delta;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}