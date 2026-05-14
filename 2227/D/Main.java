import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] a = new int[2 * n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a));
    }

    sc.close();
  }

  static int solve(int[] a) {
    int[] zeroIndices = IntStream.range(0, a.length).filter(i -> a[i] == 0).toArray();

    return Stream.of(
            extend(a, zeroIndices[0], zeroIndices[0]),
            extend(a, zeroIndices[1], zeroIndices[1]),
            extend(a, zeroIndices[0], zeroIndices[1]))
        .filter(Objects::nonNull)
        .mapToInt(
            range ->
                mex(
                    IntStream.rangeClosed(range.beginIndex(), range.endIndex())
                        .map(i -> a[i])
                        .toArray()))
        .max()
        .getAsInt();
  }

  static int mex(int[] values) {
    Set<Integer> set = Arrays.stream(values).boxed().collect(Collectors.toSet());

    int result = 0;
    while (set.contains(result)) {
      ++result;
    }

    return result;
  }

  static Range extend(int[] a, int beginIndex, int endIndex) {
    for (int i = beginIndex, j = endIndex; i < j; ++i, --j) {
      if (a[i] != a[j]) {
        return null;
      }
    }

    while (beginIndex != 0 && endIndex != a.length - 1 && a[beginIndex - 1] == a[endIndex + 1]) {
      --beginIndex;
      ++endIndex;
    }

    return new Range(beginIndex, endIndex);
  }
}

record Range(int beginIndex, int endIndex) {}
