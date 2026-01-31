import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      int q = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }
      int[] s = new int[q];
      for (int i = 0; i < s.length; ++i) {
        s[i] = sc.nextInt();
      }

      System.out.println(solve(a, s));
    }

    sc.close();
  }

  static String solve(int[] a, int[] s) {
    Arrays.sort(a);

    Set<Long> rangeSums = new HashSet<>();
    search(rangeSums, a, 0, a.length - 1);

    return Arrays.stream(s)
        .mapToObj(si -> rangeSums.contains((long) si) ? "Yes" : "No")
        .collect(Collectors.joining("\n"));
  }

  static void search(Set<Long> rangeSums, int[] a, int beginIndex, int endIndex) {
    rangeSums.add(computeRangeSum(a, beginIndex, endIndex));

    if (a[beginIndex] != a[endIndex]) {
      int middleValue = (a[beginIndex] + a[endIndex]) / 2;
      int middleIndex = find(a, beginIndex, endIndex, middleValue);

      search(rangeSums, a, beginIndex, middleIndex);
      search(rangeSums, a, middleIndex + 1, endIndex);
    }
  }

  static long computeRangeSum(int[] a, int beginIndex, int endIndex) {
    return IntStream.rangeClosed(beginIndex, endIndex).map(i -> a[i]).asLongStream().sum();
  }

  static int find(int[] a, int beginIndex, int endIndex, int middleValue) {
    int result = beginIndex;
    while (result != endIndex && a[result + 1] <= middleValue) {
      ++result;
    }

    return result;
  }
}