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
      long k = sc.nextLong();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, k));
    }

    sc.close();
  }

  static long solve(int[] a, long k) {
    long diff = Arrays.stream(a).asLongStream().sum() - k;
    if (diff <= 0) {
      return 0;
    }

    int minValue = Arrays.stream(a).min().getAsInt();
    int minIndex = IntStream.range(0, a.length).filter(i -> a[i] == minValue).findAny().getAsInt();
    int[] sortedDistances =
        IntStream.range(0, a.length)
            .filter(i -> i != minIndex)
            .map(i -> a[i] - minValue)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

    long result = diff;
    long distanceSum = 0;
    for (int i = 0; i < sortedDistances.length; ++i) {
      distanceSum += sortedDistances[i];
      result = Math.min(result, (i + 1) + (Math.max(0, diff - distanceSum) + (i + 1)) / (i + 2));
    }

    return result;
  }
}
