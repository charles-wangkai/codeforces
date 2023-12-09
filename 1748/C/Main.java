import java.util.HashMap;
import java.util.Map;
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

  static int solve(int[] a) {
    int firstZeroIndex =
        IntStream.range(0, a.length).filter(i -> a[i] == 0).findFirst().orElse(a.length);

    int result = 0;
    long sum = 0;
    for (int i = 0; i < firstZeroIndex; ++i) {
      sum += a[i];
      if (sum == 0) {
        ++result;
      }
    }

    Map<Long, Integer> sumToCount = new HashMap<>();
    sum = 0;
    for (int i = firstZeroIndex; i <= a.length; ++i) {
      if (i != a.length && a[i] != 0) {
        sum += a[i];
        sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);
      } else {
        if (!sumToCount.isEmpty()) {
          result += sumToCount.values().stream().mapToInt(Integer::intValue).max().getAsInt();
        }

        sum = 0;
        sumToCount.clear();
        sumToCount.put(sum, 1);
      }
    }

    return result;
  }
}