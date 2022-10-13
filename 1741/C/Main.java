import java.util.Scanner;

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
    int result = Integer.MAX_VALUE;
    int segmentSum = 0;
    for (int i = 0; i < a.length; ++i) {
      segmentSum += a[i];
      result = Math.min(result, computeThickness(a, segmentSum));
    }

    return result;
  }

  static int computeThickness(int[] a, int segmentSum) {
    int result = 0;
    int sum = 0;
    int beginIndex = 0;
    for (int i = 0; i < a.length; ++i) {
      sum += a[i];
      if (sum > segmentSum) {
        return Integer.MAX_VALUE;
      }
      if (sum == segmentSum) {
        result = Math.max(result, i - beginIndex + 1);
        sum = 0;
        beginIndex = i + 1;
      }
    }

    if (beginIndex != a.length) {
      return Integer.MAX_VALUE;
    }

    return result;
  }
}
