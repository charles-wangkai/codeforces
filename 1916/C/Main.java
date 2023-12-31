import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

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

  static String solve(int[] a) {
    long[] result = new long[a.length];
    long sum = 0;
    int oddCount = 0;
    for (int i = 0; i < result.length; ++i) {
      sum += a[i];
      if (a[i] % 2 == 1) {
        ++oddCount;
      }

      result[i] = sum - computeDelta(i + 1, oddCount);
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }

  static int computeDelta(int total, int oddCount) {
    if (total == 1) {
      return 0;
    }

    return oddCount / 3 + ((oddCount % 3 == 1) ? 1 : 0);
  }
}