import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    for (int tc = 0; tc < t; ++tc) {
      int n = sc.nextInt();
      long x = sc.nextLong();
      long y = sc.nextLong();
      int[] a = new int[n];
      for (int i = 0; i < a.length; ++i) {
        a[i] = sc.nextInt();
      }

      System.out.println(solve(a, x, y));
    }

    sc.close();
  }

  static long solve(int[] a, long x, long y) {
    Arrays.sort(a);

    long result = 0;
    long sum = Arrays.stream(a).asLongStream().sum();
    int beginIndex = a.length;
    int endIndex = a.length - 1;
    for (int i = a.length - 2; i >= 0; --i) {
      --beginIndex;
      while (beginIndex != a.length && a[i] + a[beginIndex] < sum - y) {
        ++beginIndex;
      }

      --endIndex;
      while (endIndex != a.length - 1 && a[i] + a[endIndex + 1] <= sum - x) {
        ++endIndex;
      }

      result += Math.max(0, endIndex - beginIndex + 1);
    }

    return result;
  }
}