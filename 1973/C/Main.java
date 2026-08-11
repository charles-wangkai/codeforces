import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int[] p = new int[n];
      for (int i = 0; i < p.length; ++i) {
        p[i] = sc.nextInt();
      }

      System.out.println(solve(p));
    }

    sc.close();
  }

  static String solve(int[] p) {
    return Arrays.stream(findPermutation(p))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(" "));
  }

  static int[] findPermutation(int[] p) {
    int n = p.length;

    int[] peakIndices = IntStream.range(0, p.length - 1).filter(i -> i % 2 == 1).toArray();

    if (Arrays.stream(peakIndices).anyMatch(peakIndex -> p[peakIndex] == 1)) {
      return reverse(findPermutation(reverse(p)));
    }

    Map<Integer, Integer> valueToIndex =
        IntStream.range(0, p.length).boxed().collect(Collectors.toMap(i -> p[i], i -> i));

    int[] sortedPeakValues =
        Arrays.stream(peakIndices).map(peakIndex -> p[peakIndex]).sorted().toArray();

    int[] result = new int[n];

    for (int i = 0; i < sortedPeakValues.length; ++i) {
      result[valueToIndex.get(sortedPeakValues[i])] = n - i;
    }

    int[] nonPeakIndices =
        IntStream.range(0, p.length).filter(i -> i == p.length - 1 || i % 2 == 0).toArray();
    int[] sortedNonPeakValues =
        Arrays.stream(nonPeakIndices).map(nonPeakIndex -> p[nonPeakIndex]).sorted().toArray();

    for (int i = 0; i < sortedNonPeakValues.length; ++i) {
      result[valueToIndex.get(sortedNonPeakValues[i])] = n - peakIndices.length - i;
    }

    return result;
  }

  static int[] reverse(int[] a) {
    return IntStream.range(0, a.length).map(i -> a[a.length - 1 - i]).toArray();
  }
}