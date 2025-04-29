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
    int leftMax = 0;
    long rightSum = Arrays.stream(a).asLongStream().sum();
    for (int i = result.length - 1; i >= 0; --i) {
      leftMax = Math.max(leftMax, a[result.length - 1 - i]);
      rightSum -= a[result.length - 1 - i];

      result[i] = leftMax + rightSum;
    }

    return Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
  }
}