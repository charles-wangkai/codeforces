import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
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

  static long solve(int[] a) {
    int[] sorted =
        Arrays.stream(a)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

    long pairSum = 0;
    int pairCount = 0;
    List<Integer> singles = new ArrayList<>();
    int index = 0;
    while (index != sorted.length) {
      if (index != sorted.length - 1 && sorted[index] == sorted[index + 1]) {
        pairSum += sorted[index];
        ++pairCount;
        index += 2;
      } else {
        singles.add(sorted[index]);
        ++index;
      }
    }

    if (pairCount == 0) {
      return 0;
    }

    if (pairCount != 1) {
      singles.add(0);
    }
    singles.add(0);

    long pairSum_ = pairSum;
    return IntStream.range(0, singles.size() - 1)
        .filter(i -> singles.get(i) - singles.get(i + 1) < 2 * pairSum_)
        .mapToLong(i -> singles.get(i) + singles.get(i + 1) + 2 * pairSum_)
        .findFirst()
        .orElse(0);
  }
}