import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();

      System.out.println(solve(n));
    }

    sc.close();
  }

  static int solve(int n) {
    int result = Integer.MIN_VALUE;
    for (int i = 1; i <= n; ++i) {
      for (int j = i; j <= n; ++j) {
        Integer maxSum = computeMaxSum(n, i, j);
        if (maxSum != null) {
          result = Math.max(result, maxSum);
        }
      }
    }

    return result;
  }

  static Integer computeMaxSum(int n, int chosen1, int chosen2) {
    int result = 0;
    NavigableSet<Integer> rest = new TreeSet<>();
    for (int value2 = 1; value2 <= n; ++value2) {
      if (value2 != chosen2) {
        rest.add(value2);
      }
    }

    for (int value1 = n; value1 >= 1; --value1) {
      if (value1 != chosen1) {
        Integer value2 = rest.floor(chosen1 * chosen2 / value1);
        if (value2 == null) {
          return null;
        }

        result += value1 * value2;
        rest.remove(value2);
      }
    }

    return result;
  }
}
