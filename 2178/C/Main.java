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
    long result = Long.MIN_VALUE;
    long leftSum = 0;
    long rightSum = IntStream.range(1, a.length).map(i -> -a[i]).asLongStream().sum();
    for (int i = 0; i < a.length; ++i) {
      result = Math.max(result, leftSum + rightSum);

      leftSum += (i == 0) ? a[i] : Math.abs(a[i]);

      if (i != a.length - 1) {
        rightSum -= -a[i + 1];
      }
    }

    return result;
  }
}