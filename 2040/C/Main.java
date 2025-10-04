import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      long k = sc.nextLong();

      System.out.println(solve(n, k));
    }

    sc.close();
  }

  static String solve(int n, long k) {
    if (computeWayNum(n, k) != Long.MAX_VALUE) {
      return "-1";
    }

    int[] result = new int[n];
    int leftIndex = 0;
    int rightIndex = result.length - 1;
    for (int value = 1; value <= n; ++value) {
      long wayNum = computeWayNum(rightIndex - leftIndex, k);
      if (wayNum == Long.MAX_VALUE) {
        result[leftIndex] = value;
        ++leftIndex;
      } else {
        k -= wayNum;

        result[rightIndex] = value;
        --rightIndex;
      }
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static long computeWayNum(int length, long limit) {
    long result = 1;
    for (int i = 0; i < length - 1; ++i) {
      result *= 2;
      if (result >= limit) {
        return Long.MAX_VALUE;
      }
    }

    return (result >= limit) ? Long.MAX_VALUE : result;
  }
}