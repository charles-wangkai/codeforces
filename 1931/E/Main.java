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
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, m));
    }

    sc.close();
  }

  static String solve(int[] a, int m) {
    int[] trailingZeroNums =
        Arrays.stream(a)
            .map(Main::computeTrailingZeroNum)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

    return (Arrays.stream(a).map(x -> String.valueOf(x).length()).sum()
                - IntStream.range(0, trailingZeroNums.length)
                    .filter(i -> i % 2 == 0)
                    .map(i -> trailingZeroNums[i])
                    .sum()
            >= m + 1)
        ? "Sasha"
        : "Anna";
  }

  static int computeTrailingZeroNum(int x) {
    int result = 0;
    while (x % 10 == 0) {
      ++result;
      x /= 10;
    }

    return result;
  }
}