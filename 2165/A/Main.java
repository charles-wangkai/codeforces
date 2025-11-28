import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;
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
    int[] sortedIndices =
        IntStream.range(0, a.length)
            .boxed()
            .sorted(Comparator.comparing(i -> a[i]))
            .mapToInt(Integer::intValue)
            .limit(a.length - 1)
            .toArray();

    NavigableSet<Integer> rests = new TreeSet<>();
    for (int i = 0; i < a.length; ++i) {
      rests.add(i);
    }

    long result = 0;
    for (int index : sortedIndices) {
      Integer leftIndex = rests.lower(index);
      if (leftIndex == null) {
        leftIndex = rests.last();
      }

      Integer rightIndex = rests.higher(index);
      if (rightIndex == null) {
        rightIndex = rests.first();
      }

      result += a[(a[leftIndex] <= a[rightIndex]) ? leftIndex : rightIndex];

      rests.remove(index);
    }

    return result;
  }
}